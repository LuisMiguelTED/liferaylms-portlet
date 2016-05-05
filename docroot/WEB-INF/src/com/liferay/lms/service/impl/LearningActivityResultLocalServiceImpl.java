/**
 * 2012 TELEFONICA LEARNING SERVICES. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.lms.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.xml.sax.InputSource;

import com.liferay.lms.auditing.AuditConstants;
import com.liferay.lms.auditing.AuditingLogFactory;
import com.liferay.lms.learningactivity.calificationtype.CalificationType;
import com.liferay.lms.learningactivity.calificationtype.CalificationTypeRegistry;
import com.liferay.lms.model.Course;
import com.liferay.lms.model.LearningActivity;
import com.liferay.lms.model.LearningActivityResult;
import com.liferay.lms.model.LearningActivityTry;
import com.liferay.lms.model.SCORMContent;
import com.liferay.lms.service.ClpSerializer;
import com.liferay.lms.service.CourseLocalServiceUtil;
import com.liferay.lms.service.LearningActivityLocalServiceUtil;
import com.liferay.lms.service.LearningActivityResultLocalServiceUtil;
import com.liferay.lms.service.LearningActivityTryLocalServiceUtil;
import com.liferay.lms.service.ModuleResultLocalServiceUtil;
import com.liferay.lms.service.SCORMContentLocalServiceUtil;
import com.liferay.lms.service.base.LearningActivityResultLocalServiceBaseImpl;
import com.liferay.lms.service.persistence.LearningActivityResultUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;


public class LearningActivityResultLocalServiceImpl	extends LearningActivityResultLocalServiceBaseImpl {

	private Log log = LogFactoryUtil.getLog(LearningActivityResultLocalServiceImpl.class);


	public LearningActivityResult update(LearningActivityTry learningActivityTry) throws SystemException, PortalException{

		long actId=learningActivityTry.getActId();
		long userId=learningActivityTry.getUserId();
		LearningActivityResult learningActivityResult=getByActIdAndUserId(actId, userId);
		LearningActivity learningActivity=LearningActivityLocalServiceUtil.getLearningActivity(actId);
		if(learningActivityResult==null){	
			learningActivityResult=
					learningActivityResultPersistence.create(counterLocalService.increment(
							LearningActivityResult.class.getName()));
			learningActivityResult.setStartDate(learningActivityTry.getStartDate());
			learningActivityResult.setActId(actId);
			learningActivityResult.setUserId(userId);
			learningActivityResult.setPassed(false);
		}else{
			learningActivityResult=learningActivityResultPersistence.fetchByact_user(actId, userId);
		}

		if(learningActivityTry.getEndDate()!=null){
			long cuantosTryLlevo=LearningActivityTryLocalServiceUtil.getTriesCountByActivityAndUser(actId, userId);
			if(learningActivity.getTries()>0&&cuantosTryLlevo>=learningActivity.getTries()){
				learningActivityResult.setEndDate(learningActivityTry.getEndDate());
			}

			if(learningActivityTry.getResult()>learningActivityResult.getResult()){			
				learningActivityResult.setResult(learningActivityTry.getResult());
			}

			if(!learningActivityResult.getPassed()){
				if(learningActivityTry.getResult()>=learningActivity.getPasspuntuation()){
					learningActivityResult.setEndDate(learningActivityTry.getEndDate());
					learningActivityResult.setPassed(true);				  
				}
			}	

			learningActivityResult.setComments(learningActivityTry.getComments());
		}

		learningActivityResultPersistence.update(learningActivityResult, true);
		ModuleResultLocalServiceUtil.update(learningActivityResult);


		//auditing
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		if(serviceContext!=null){
			AuditingLogFactory.audit(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), LearningActivityResult.class.getName(), 
					learningActivityResult.getPrimaryKey(), learningActivityTry.getUserId(), AuditConstants.UPDATE, null);
		}else{
			LearningActivity la = learningActivityPersistence.fetchByPrimaryKey(actId);
			if(la!=null){
				AuditingLogFactory.audit(la.getCompanyId(), la.getGroupId(), LearningActivityResult.class.getName(), 
						learningActivityResult.getPrimaryKey(), learningActivityTry.getUserId(), AuditConstants.UPDATE, null);
			}
		}

		return learningActivityResult;

	}
	public LearningActivityResult update(long latId, long result, String tryResultData, long userId) throws SystemException, PortalException {
		LearningActivityTry learningActivityTry = LearningActivityTryLocalServiceUtil.getLearningActivityTry(latId);
		if (userId != learningActivityTry.getUserId()) {
			throw new PortalException();
		}
		if (result >= 0) {
			learningActivityTry.setResult(result);

			Date endDate = new Date(System.currentTimeMillis());
			learningActivityTry.setEndDate(endDate);
		}
		learningActivityTry.setTryResultData(tryResultData);
		LearningActivityTryLocalServiceUtil.updateLearningActivityTry(learningActivityTry);

		return update(learningActivityTry);
	}
	public LearningActivityResult update(long latId, String tryResultData, long userId) throws SystemException, PortalException {
		LearningActivityTry learningActivityTry = learningActivityTryLocalService.getLearningActivityTry(latId);
		if (userId != learningActivityTry.getUserId()) {
			throw new PortalException();
		}

		/************************************************************************************
		boolean isMaxScoreByPassed = GetterUtil.getBoolean(PropsUtil.get("scorm.max.score.by.passed"),false);
		/************************************************************************************/




		LearningActivity learningActivity = learningActivityLocalService.getLearningActivity(learningActivityTry.getActId());
		String assetEntryId = learningActivityLocalService.getExtraContentValue(learningActivityTry.getActId(), "assetEntry");
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.getAssetEntry(Long.valueOf(assetEntryId));

		List<String> manifestItems = new ArrayList<String>();
		Map<String, String> recursos = new HashMap<String, String>();

		Map<String, String> manifestResources = new HashMap<String, String>();
		try {
			String urlString = assetEntry.getUrl();
			if (Validator.isNotNull(urlString)) {
				Document imsdocument = null;
				URL url = new URL(urlString);
				if (urlString.startsWith("http://") || urlString.startsWith("https://")) {
					SCORMContent _scorm =  SCORMContentLocalServiceUtil.getSCORMContent(assetEntry.getClassPK());
					String rutaDatos = SCORMContentLocalServiceUtil.getBaseDir();

					String urlIndex=rutaDatos+"/"+Long.toString(_scorm.getCompanyId())+"/"+Long.toString(_scorm.getGroupId())+"/"+_scorm.getUuid()+"/imsmanifest.xml";

					InputStream inputStream= new FileInputStream(urlIndex);
					Reader reader = new InputStreamReader(inputStream,"UTF-8");

					InputSource is = new InputSource(reader);
					is.setEncoding("UTF-8");

					imsdocument = SAXReaderUtil.read(reader);
				}
				if (urlString.startsWith("file://")) {
					imsdocument = SAXReaderUtil.read(new File( URLDecoder.decode( url.getFile(), "UTF-8" ) ));
				}
				List<Element> resources = new ArrayList<Element>();
				resources = imsdocument.getRootElement().element("resources").elements("resource");
				for(Element resource : resources) {
					String identifier = resource.attributeValue("identifier");
					String type = resource.attributeValue("scormType");
					String type2 = resource.attributeValue("scormtype");
					manifestResources.put(identifier, type != null ? type : type2);
				}

				List<Element> items = new ArrayList<Element>();
				items.addAll(imsdocument.getRootElement().element("organizations").elements("organization").get(0).elements("item"));
				for (int i = 0; i < items.size(); i++) {
					Element item = items.get(i);
					String identifier = item.attributeValue("identifier");
					String identifierref = item.attributeValue("identifierref");
					manifestItems.add(identifier);
					recursos.put(identifier, identifierref);
					items.addAll(item.elements("item"));
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 


		Long master_score = new Integer(learningActivity.getPasspuntuation()).longValue();
		JSONObject scorm = JSONFactoryUtil.createJSONObject();
		scorm = JSONFactoryUtil.createJSONObject(tryResultData);
		JSONObject organizations = scorm.getJSONObject("organizations");
		JSONArray organizationNames = organizations.names();
		JSONObject organization = organizations.getJSONObject(organizationNames.getString(0));

		JSONObject cmis = organization.getJSONObject("cmi");
		JSONArray cmiNames = cmis.names();
		List<String> completion_statuses = new ArrayList<String>();
		List<String> success_statuses = new ArrayList<String>();
		List<Long> scores = new ArrayList<Long>();

		String total_completion_status = "not attempted";
		String total_lesson_status = "unknown";
		Double total_score = 0.0;

		for (int i = 0; i < cmiNames.length(); i++) {
			JSONObject cmi = cmis.getJSONObject(cmiNames.getString(0));
			String typeCmi = manifestResources.get(recursos.get(cmiNames.getString(i)));

			String completion_status = null;
			String success_status = null;
			Double max_score = null;
			Double min_score = null;
			Double raw_score = null;
			Double scaled_score = null;
			Long scaled_score_long = null;
			String suspend_data = cmi.getJSONObject("cmi.suspend_data").getString("value");

			if (cmi.getJSONObject("cmi.core.lesson_status") != null) { // 1.2
				if(log.isDebugEnabled())log.debug("VERSION 1.2");
				String lesson_status = cmi.getJSONObject("cmi.core.lesson_status").getString("value");
				//"passed", "completed", "failed", "incomplete", "browsed", "not attempted"
				if ("passed".equals(lesson_status)) {
					success_status = "passed";
					completion_status = "completed";
				} else if ("failed".equals(lesson_status)) {
					success_status = "failed";
					completion_status = "completed";
				} else if ("completed".equals(lesson_status)) { 
					success_status = "passed"; // or passed
					completion_status = "completed";
				} else if ("browsed".equals(lesson_status)) {
					success_status = "passed";
					completion_status = "completed";
				} else if ("incomplete".equals(lesson_status)) {
					success_status = "unknown";
					completion_status = "incomplete";
				} else if ("not attempted".equals(lesson_status)) {
					success_status = "unknown";
					completion_status = "not attempted";
					if (suspend_data.contains("1")) {
						completion_status = "completed";
						if (suspend_data.contains("0")) {
							completion_status = "incomplete";
						}
						tryResultData.replaceAll("\"not attempted\"", "\""+completion_status+"\"");
					}
				}
				max_score = cmi.getJSONObject("cmi.core.score.max").getDouble("value", 100);
				min_score = cmi.getJSONObject("cmi.core.score.min").getDouble("value", 0);
				raw_score = cmi.getJSONObject("cmi.core.score.raw").getDouble("value", "asset".equals(typeCmi) ? 100 : 0);

				/**********************************************************************************************************************
				if(log.isDebugEnabled())log.debug("ConvertPassedToMaxSCORE?  "+isMaxScoreByPassed);
				if( ("passed".equalsIgnoreCase(lesson_status)||"completed".equalsIgnoreCase(lesson_status)) &&  isMaxScoreByPassed){

					raw_score = 69.0;

				}
				/***********************************************************************************************************************/


				scaled_score = new Double(Math.round((raw_score * 100) / (max_score - min_score)));
				scaled_score_long = Math.round(scaled_score);
			} else { // 1.3
				if(log.isDebugEnabled())log.debug("VERSION 1.3");
				//"completed", "incomplete", "not attempted", "unknown"
				completion_status = cmi.getJSONObject("cmi.completion_status").getString("value");
				//"passed", "failed", "unknown"
				success_status = cmi.getJSONObject("cmi.success_status").getString("value");
				max_score = cmi.getJSONObject("cmi.score.max").getDouble("value", 100);
				min_score = cmi.getJSONObject("cmi.score.min").getDouble("value", 0);
				raw_score = cmi.getJSONObject("cmi.score.raw").getDouble("value", "asset".equals(typeCmi) ? 100 : 0);

				/***********************************************************************************************************************
				if(log.isDebugEnabled())log.debug("ConvertPassedToMaxSCORE?  "+isMaxScoreByPassed);
				if( ("passed".equalsIgnoreCase(success_status)||"completed".equalsIgnoreCase(completion_status)) &&  isMaxScoreByPassed){

					raw_score = 69.0;
					if(log.isDebugEnabled())log.debug("HE PASADO Y PONGO EL RAW_SCORE "+raw_score);
				}
				/***********************************************************************************************************************/

				scaled_score = new Double(Math.round((raw_score * 100) / (max_score - min_score)));
				scaled_score = cmi.getJSONObject("cmi.score.scaled").getDouble("value", -1) != -1 ? (cmi.getJSONObject("cmi.score.scaled").getDouble("value") * (max_score - min_score) + min_score) : scaled_score;
				scaled_score_long = Math.round(scaled_score);
				if(log.isDebugEnabled())log.debug("scaled_score_long 1.3"+scaled_score_long);

			}
			completion_statuses.add(completion_status);
			success_statuses.add(success_status);
			scores.add(scaled_score_long);
		}

		if (manifestItems.size() <= 1) {
			if (completion_statuses.size() == 1) {
				total_completion_status = completion_statuses.get(0);
			}
			if (success_statuses.size() == 1) {
				total_lesson_status = success_statuses.get(0);
			}
		} else {
			if (success_statuses.size() < manifestItems.size()) {
				total_lesson_status = "unknown";
			} else if (success_statuses.size() == manifestItems.size()) {
				for (int i = 0; i < success_statuses.size(); i++) {
					if ("unknown".equals(success_statuses.get(i))) {
						total_lesson_status = "unknown";
						break;
					}
					if ("passed".equals(success_statuses.get(i))) {
						if ("passed".equals(total_lesson_status)) {
							total_lesson_status = "passed";
						}
						if ("failed".equals(total_lesson_status)) {
							total_lesson_status = "unknown";
							break;
						}
					}
					if ("failed".equals(success_statuses.get(i))) {
						if ("passed".equals(total_lesson_status)) {
							total_lesson_status = "unknown";
							break;
						}
						if ("failed".equals(total_lesson_status)) {
							total_lesson_status = "failed";
						}
					}
				}
			}
			if (completion_statuses.size() < manifestItems.size()) {
				if (completion_statuses.size() <= 1) {
					total_completion_status = completion_statuses.get(0).equals("completed") ? "incomplete" : completion_statuses.get(0);
				} else {
					total_completion_status = "incomplete";
				}
			} else if (completion_statuses.size() == manifestItems.size()) {
				for (int i = 0; i < completion_statuses.size(); i++) {
					total_score += scores.get(i);
					if ("incomplete".equals(completion_statuses.get(i))) {
						total_completion_status = "incomplete";
						break;
					}
					if ("completed".equals(completion_statuses.get(i))) {
						if ("not attempted".equals(total_completion_status)) {
							total_completion_status = "completed";
						}
						if ("unknown".equals(total_completion_status)) {
							total_completion_status = "incomplete";
							break;
						}
					}
					if ("not attempted".equals(completion_statuses.get(i))) {
						if ("completed".equals(total_completion_status)) {
							total_completion_status = "incomplete";
							break;
						}
						if ("unknown".equals(total_completion_status)) {
							total_completion_status = "unknown";
						}
					}
					if ("unknown".equals(completion_statuses.get(i))) {
						if ("completed".equals(total_completion_status)) {
							total_completion_status = "incomplete";
							break;
						}
						if ("unknown".equals(total_completion_status) || "not attempted".equals(total_completion_status)) {
							total_completion_status = "unknown";
						}
					}
				}
			}
		}
		//System.out.println("total_completion_status "+total_completion_status);
		for (int i = 0; i < scores.size(); i++) {
			total_score += scores.get(i);
		}
		total_score = total_score / (manifestItems.size() > 0 ? manifestItems.size() : 1);
		//System.out.println("BEFORE incomplete");
		if ("incomplete".equals(total_completion_status) || "completed".equals(total_completion_status)) {
			learningActivityTry.setTryResultData(tryResultData);
			learningActivityTry.setResult(Math.round(total_score));

			if (Math.round(total_score) >= master_score || "passed".equals(total_lesson_status)) {
				Date endDate = new Date();
				learningActivityTry.setEndDate(endDate);
			}

			learningActivityTryLocalService.updateLearningActivityTry(learningActivityTry);

			// If SCO says that the activity has been passed, then the learning activity result has to be marked as passed
			if ("passed".equals(total_lesson_status)) {
				LearningActivityResult laresult = learningActivityResultLocalService.getByActIdAndUserId(learningActivityTry.getActId(), userId);
				if (!laresult.getPassed()) {
					laresult.setPassed(true);
					laresult.setResult(Math.round(total_score));
					laresult.setEndDate(new Date(System.currentTimeMillis()));
					learningActivityResultLocalService.updateLearningActivityResult(laresult);
					if(laresult.getPassed())
					{
						moduleResultLocalService.update(laresult);
					}
				}
			}
			// If SCO says that the activity has been failed, then the learning activity result has to be marked as failed

			if ("failed".equals(total_lesson_status)) {
				LearningActivityResult laresult = learningActivityResultLocalService.getByActIdAndUserId(learningActivityTry.getActId(), userId);
				if (!laresult.getPassed()) {
					laresult.setPassed(false);
					laresult.setEndDate(new Date(System.currentTimeMillis()));
					learningActivityResultLocalService.updateLearningActivityResult(laresult);
					moduleResultLocalService.update(laresult);

				}
			}

		}

		return this.getByActIdAndUserId(learningActivityTry.getActId(), userId);
	}
	public LearningActivityResult update(long latId, String tryResultData, String imsmanifest, long userId) throws SystemException, PortalException {
		LearningActivityTry learningActivityTry = learningActivityTryLocalService.getLearningActivityTry(latId);
		if (userId != learningActivityTry.getUserId()) {
			throw new PortalException();
		}

		/***********************************************************************************
		boolean isMaxScoreByPassed = GetterUtil.getBoolean(PropsUtil.get("scorm.max.score.by.passed"),false);
		/************************************************************************************/

		LearningActivity learningActivity = learningActivityLocalService.getLearningActivity(learningActivityTry.getActId());
		boolean completedAsPassed = GetterUtil.getBoolean(LearningActivityLocalServiceUtil.getExtraContentValue(learningActivityTry.getActId(), "completedAsPassed"), false);
		long passPuntuation=learningActivity.getPasspuntuation();
		List<String> manifestItems = new ArrayList<String>();
		Map<String, String> recursos = new HashMap<String, String>();

		Map<String, String> manifestResources = new HashMap<String, String>();
		boolean isPureAsset = false;
		long scos=0;
		long assets=0;

		try {
			if (Validator.isNotNull(imsmanifest)) {
				Document imsdocument = SAXReaderUtil.read(imsmanifest);
				List<Element> resources = new ArrayList<Element>();
				resources = imsdocument.getRootElement().element("resources").elements("resource");
				isPureAsset = true;
				for(Element resource : resources) {
					String identifier = resource.attributeValue("identifier");
					String type = resource.attributeValue("scormType");
					String type2 = resource.attributeValue("scormtype");

					String type3 = type != null ? type : type2 != null ? type2 : "asset";

					if (!"asset".equalsIgnoreCase(type3)) {
						isPureAsset = false;
						scos++;
					}
					else
					{
						assets++;
					}
					manifestResources.put(identifier, type3);
				}
				List<Element> items = new ArrayList<Element>();
				items.addAll(imsdocument.getRootElement().element("organizations").elements("organization").get(0).elements("item"));
				for (int i = 0; i < items.size(); i++) {
					Element item = items.get(i);
					String identifier = item.attributeValue("identifier");
					String identifierref = item.attributeValue("identifierref");
					if(identifier!=null && !"".equals(identifier)&&identifierref!=null && !"".equals(identifierref))
					{
						manifestItems.add(identifier);
						recursos.put(identifier, identifierref);
					}
					items.addAll(item.elements("item"));
				}
			}
		} catch (DocumentException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}

		Long master_score = new Integer(learningActivity.getPasspuntuation()).longValue();

		JSONObject scorm = JSONFactoryUtil.createJSONObject();
		scorm = JSONFactoryUtil.createJSONObject(tryResultData);

		JSONObject organizations = scorm.getJSONObject("organizations");
		JSONArray organizationNames = organizations.names();
		JSONObject organization = organizations.getJSONObject(organizationNames.getString(0));

		JSONObject cmis = organization.getJSONObject("cmi");
		JSONArray cmiNames = cmis.names();

		List<String> completion_statuses = new ArrayList<String>();
		List<String> success_statuses = new ArrayList<String>();
		List<Long> scores = new ArrayList<Long>();

		String total_completion_status = "not attempted";
		String total_lesson_status = "";
		Double total_score = 0.0;

		if (cmis.length() == 0) { // Asset
			log.debug("isPureAsset? "+isPureAsset);
			if (isPureAsset) {
				for (int i = 0; i < manifestItems.size(); i++) {
					completion_statuses.add("completed");
					success_statuses.add("passed");
					scores.add(new Long(100));
				}
				total_completion_status = "completed";
				total_lesson_status = "passed";
			} else {
				throw new PortalException();
			}
		} else {
			for (int i = 0; i < assets; i++) {
				completion_statuses.add("completed");
				success_statuses.add("passed");
				//scores.add(new Long(100));
			}
			for (int i = 0; i < cmiNames.length(); i++) {
				JSONObject cmi = cmis.getJSONObject(cmiNames.getString(i));
				String typeCmi = manifestResources.get(recursos.get(cmiNames.getString(i)));

				String completion_status = null;
				String success_status = null;
				Double max_score = null;
				Double min_score = null;
				Double raw_score = null;
				Double scaled_score = null;
				Long scaled_score_long = null;
				String suspend_data = cmi.getJSONObject("cmi.suspend_data").getString("value");

				if (cmi.getJSONObject("cmi.core.lesson_status") != null) { // 1.2
					if(log.isDebugEnabled())log.debug("VERSION 1.2");
					String lesson_status = cmi.getJSONObject("cmi.core.lesson_status").getString("value");
					//"passed", "completed", "failed", "incomplete", "browsed", "not attempted"
					if ("passed".equals(lesson_status)) {
						success_status = "passed";
						completion_status = "completed";
					} else if ("failed".equals(lesson_status)) {
						success_status = "failed";
						completion_status = "completed";
					} else if ("completed".equals(lesson_status)) { 
						if(completedAsPassed)
						{
							success_status = "passed"; // or passed
						}
						else
						{
							success_status = "unknown";
						}
						completion_status = "completed";
					} else if ("browsed".equals(lesson_status)) {
						success_status = "passed";
						completion_status = "completed";
					} else if ("incomplete".equals(lesson_status)) {
						success_status = "unknown";
						completion_status = "incomplete";
					} else if ("not attempted".equals(lesson_status)) {
						success_status = "unknown";
						completion_status = "not attempted";
						if (suspend_data.contains("1")) {
							completion_status = "completed";
							if (suspend_data.contains("0")) {
								completion_status = "incomplete";
							}
							tryResultData.replaceAll("\"not attempted\"", "\""+completion_status+"\"");
						}
					}
					max_score = cmi.getJSONObject("cmi.core.score.max").getDouble("value", 100);
					min_score = cmi.getJSONObject("cmi.core.score.min").getDouble("value", 0);
					raw_score = cmi.getJSONObject("cmi.core.score.raw").getDouble("value", "asset".equals(typeCmi) ? max_score : 0);

					if("passed".equals(success_status) && raw_score==0 && completedAsPassed)
					{
						raw_score=(double) passPuntuation;
					}

					/*********************************************************************************************************************
					if(log.isDebugEnabled())log.debug("ConvertPassedToMaxSCORE?  "+isMaxScoreByPassed);
					if( ("passed".equalsIgnoreCase(lesson_status)||"completed".equalsIgnoreCase(lesson_status)) &&  isMaxScoreByPassed){

						raw_score = 69.0;

					}
					/***********************************************************************************************************************/


					scaled_score = new Double(Math.round((raw_score * 100) / (max_score - min_score)));
					scaled_score_long = Math.round(scaled_score);
				} else { // 1.3
					//"completed", "incomplete", "not attempted", "unknown"
					if(log.isDebugEnabled())log.debug("VERSION 1.3");
					completion_status = cmi.getJSONObject("cmi.completion_status").getString("value");
					if ("completed".equals(completion_status)) { 
						if(completedAsPassed)
						{
							success_status = "passed"; // or passed
						}
						else
						{
							success_status = cmi.getJSONObject("cmi.success_status").getString("value");
						}
					}
					else
					{
						success_status = cmi.getJSONObject("cmi.success_status").getString("value");
					}
					//"passed", "failed", "unknown"

					max_score = cmi.getJSONObject("cmi.score.max").getDouble("value", 100);
					min_score = cmi.getJSONObject("cmi.score.min").getDouble("value", 0);
					raw_score = cmi.getJSONObject("cmi.score.raw").getDouble("value", "asset".equals(typeCmi) ? 100 : 0);
					if("passed".equals(success_status) && raw_score==0 && completedAsPassed)
					{
						raw_score=(double) passPuntuation;
					}

					/*********************************************************************************************************************
					if(log.isDebugEnabled())log.debug("ConvertPassedToMaxSCORE?  "+isMaxScoreByPassed);
					if( ("passed".equalsIgnoreCase(success_status)||"completed".equalsIgnoreCase(completion_status)) &&  isMaxScoreByPassed){

						raw_score = 69.0;

					}
					/***********************************************************************************************************************/
					scaled_score = new Double(Math.round((raw_score * 100) / (max_score - min_score)));
					scaled_score = cmi.getJSONObject("cmi.score.scaled").getDouble("value", -1) != -1 ? (cmi.getJSONObject("cmi.score.scaled").getDouble("value") * (max_score - min_score) + min_score) : scaled_score;
					scaled_score_long = Math.round(scaled_score);
				}
				if(log.isDebugEnabled()){
					log.debug("completion_status "+completion_status);
					log.debug("success_statuses "+success_statuses);
					log.debug("scaled_score_long "+scaled_score_long);

				}

				completion_statuses.add(completion_status);
				success_statuses.add(success_status);
				scores.add(scaled_score_long);
			}
		}

		if (!isPureAsset){
			if (manifestItems.size() <= 1) {
				if (completion_statuses.size() == 1) {
					total_completion_status = completion_statuses.get(0);
				}
				if (success_statuses.size() == 1) {
					total_lesson_status = success_statuses.get(0);
				}
			}else{
				if (success_statuses.size() < manifestItems.size()){
					total_lesson_status = "unknown";
				}else if (success_statuses.size() == manifestItems.size()) {
					for (int i = 0; i < success_statuses.size(); i++) {
						if ("unknown".equals(success_statuses.get(i))) {
							total_lesson_status = "unknown";
							break;
						}
						if ("passed".equals(success_statuses.get(i))) {
							if ("passed".equals(total_lesson_status)||"".equals(total_lesson_status)) {
								total_lesson_status = "passed";
							}
							if ("failed".equals(total_lesson_status)) {
								total_lesson_status = "unknown";
								break;
							}
						}
						if ("failed".equals(success_statuses.get(i))) {
							if ("passed".equals(total_lesson_status)) {
								total_lesson_status = "unknown";
								break;
							}
							if ("failed".equals(total_lesson_status)) {
								total_lesson_status = "failed";
							}
						}
					}
				}
				if (completion_statuses.size() < manifestItems.size()) {
					if (completion_statuses.size() <= 1) {
						total_completion_status = completion_statuses.get(0).equals("completed") ? "incomplete" : completion_statuses.get(0);
					} else {
						total_completion_status = "incomplete";
					}
				}else if (completion_statuses.size() == manifestItems.size()) {
					for (int i = 0; i < completion_statuses.size(); i++) {
						//total_score += scores.get(i);
						if ("incomplete".equals(completion_statuses.get(i))) {
							total_completion_status = "incomplete";
							break;
						}
						if ("completed".equals(completion_statuses.get(i))) {
							if ("not attempted".equals(total_completion_status)) {
								total_completion_status = "completed";
							}
							if ("unknown".equals(total_completion_status)) {
								total_completion_status = "incomplete";
								break;
							}
						}
						if ("not attempted".equals(completion_statuses.get(i))) {
							if ("completed".equals(total_completion_status)) {
								total_completion_status = "incomplete";
								break;
							}
							if ("unknown".equals(total_completion_status)) {
								total_completion_status = "unknown";
							}
						}
						if ("unknown".equals(completion_statuses.get(i))) {
							if ("completed".equals(total_completion_status)) {
								total_completion_status = "incomplete";
								break;
							}
							if ("unknown".equals(total_completion_status) || "not attempted".equals(total_completion_status)) {
								total_completion_status = "unknown";
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < scores.size(); i++) {
			total_score += scores.get(i);
			if(log.isDebugEnabled()){
				log.debug("total_score "+total_score);
			}
		}
		if(scos>0){
			total_score = total_score / (scos);	
			if(log.isDebugEnabled()){
				log.debug("total_score / (scos); "+total_score);
			}
		}else{
			total_score = total_score / ((scos+assets) > 0 ? (scos+assets) : 1);
			if(log.isDebugEnabled()){
				log.debug("total_score / ((scos+assets) > 0 ? (scos+assets) : 1) "+total_score);
			}
		}

		if ("incomplete".equals(total_completion_status) || "completed".equals(total_completion_status)) {
			if(log.isDebugEnabled()){
				log.debug("total_completion_status "+total_completion_status);
			}
			learningActivityTry.setTryResultData(tryResultData);
			learningActivityTry.setResult(Math.round(total_score));
			if (Math.round(total_score) >= master_score)
			{
				total_lesson_status="passed";
			}
			learningActivityTryLocalService.updateLearningActivityTry(learningActivityTry);

			// If SCO says that the activity has been passed, then the learning activity result has to be marked as passed
			if ("passed".equals(total_lesson_status)) {
				LearningActivityResult laresult = learningActivityResultLocalService.getByActIdAndUserId(learningActivityTry.getActId(), userId);
				if (!laresult.getPassed()) {
					laresult.setPassed(true);
					laresult.setEndDate(new Date());
					laresult.setResult(Math.round(total_score));

					learningActivityResultLocalService.updateLearningActivityResult(laresult);
					moduleResultLocalService.update(laresult);
				}
			}
			// If SCO says that the activity has been failed, then the learning activity result has to be marked as failed

			if ("failed".equals(total_lesson_status)) {
				LearningActivityResult laresult = learningActivityResultLocalService.getByActIdAndUserId(learningActivity.getActId(), userId);
				long  userTries = LearningActivityTryLocalServiceUtil.getLearningActivityTryByActUserCount(laresult.getActId(), userId);

				if (laresult.getEndDate()==null && learningActivity.getTries() <= userTries && learningActivity.getTries() != 0) {
					laresult.setPassed(false);
					laresult.setEndDate(new Date());
					learningActivityResultLocalService.updateLearningActivityResult(laresult);
					moduleResultLocalService.update(laresult);

				}
			}

		}

		//auditing
		if(learningActivity!=null){
			AuditingLogFactory.audit(learningActivity.getCompanyId(), learningActivity.getGroupId(), LearningActivityResult.class.getName(), 
					learningActivity.getPrimaryKey(), learningActivity.getUserId(), AuditConstants.UPDATE, null);
		}
		return this.getByActIdAndUserId(learningActivityTry.getActId(), userId);
	}
	
	
	
	public boolean existsLearningActivityResult(long actId,long userId) throws SystemException{
		return learningActivityResultPersistence.countByact_user(actId, userId)>0;
	}

	public boolean userPassed(long actId,long userId) throws SystemException{
		if(!existsLearningActivityResult(actId, userId)){
			return false;
		}else{
			return getByActIdAndUserId(actId, userId).isPassed();
		}
	}
	public long countPassed(long actId) throws SystemException{
		return learningActivityResultPersistence.countByap(actId, true);
	}

	public long countPassedOnlyStudents(long actId, long companyId, long courseGropupCreatedId, boolean passed) throws SystemException{
		return countPassedOnlyStudents(actId, companyId, courseGropupCreatedId, passed, null);
	}

	public long countPassedOnlyStudents(long actId, long companyId, long courseGropupCreatedId, boolean passed, List<User> _students) throws SystemException{
		long res = 0;
		List<User> students = null;
		// Se prepara el metodo para recibir un Listado de estudiantes especificos,, por ejemplo que pertenezcan a alguna organizacion. Sino, se trabaja con todos los estudiantes del curso.
		if(Validator.isNotNull(_students) && _students.size() > 0)
			students = _students;
		else
			students = CourseLocalServiceUtil.getStudentsFromCourse(companyId, courseGropupCreatedId);

		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
		DynamicQuery consulta = DynamicQueryFactoryUtil.forClass(LearningActivityResult.class, classLoader)
				.add(PropertyFactoryUtil.forName("actId").eq(actId));

		if(Validator.isNotNull(students) && students.size() > 0) {
			Criterion criterion = null;
			for (int i = 0; i < students.size(); i++) {
				if(i==0) {
					criterion = RestrictionsFactoryUtil.like("userId", students.get(i).getUserId());
				} else {
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("userId", students.get(i).getUserId()));
				}
			}
			if(Validator.isNotNull(criterion)) {
				criterion=RestrictionsFactoryUtil.and(criterion,
						RestrictionsFactoryUtil.eq("passed",new Boolean (true)));

				consulta.add(criterion);

				List<LearningActivityResult> results = learningActivityResultPersistence.findWithDynamicQuery(consulta);
				if(results!=null && !results.isEmpty()) {
					res = results.size();
				}
			}
		}

		return res;

	}

	public long countNotPassed(long actId) throws SystemException
	{
		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader"); 
		DynamicQuery dq=DynamicQueryFactoryUtil.forClass(LearningActivityResult.class, classLoader);
		Criterion criterion=PropertyFactoryUtil.forName("passed").eq(false);
		dq.add(criterion);
		criterion=PropertyFactoryUtil.forName("actId").eq(actId);
		dq.add(criterion);
		criterion=PropertyFactoryUtil.forName("endDate").isNotNull();
		dq.add(criterion);
		return learningActivityResultPersistence.countWithDynamicQuery(dq);
	}


	public long countNotPassedOnlyStudents(long actId, long companyId, long courseGropupCreatedId) throws SystemException{
		return countNotPassedOnlyStudents(actId, companyId, courseGropupCreatedId, null); 
	}


	public long countNotPassedOnlyStudents(long actId, long companyId, long courseGropupCreatedId, List<User> _students) throws SystemException
	{
		long res = 0;
		List<User> students = null;
		// Se prepara el metodo para recibir un Listado de estudiantes especificos,, por ejemplo que pertenezcan a alguna organizacion. Sino, se trabaja con todos los estudiantes del curso.
		if(Validator.isNotNull(_students) && _students.size() > 0)
			students = _students;
		else
			students = CourseLocalServiceUtil.getStudentsFromCourse(companyId, courseGropupCreatedId);

		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
		DynamicQuery consulta = DynamicQueryFactoryUtil.forClass(LearningActivityResult.class, classLoader)
				.add(PropertyFactoryUtil.forName("actId").eq(actId));

		if(Validator.isNotNull(students) && students.size() > 0) {
			Criterion criterion = null;
			for (int i = 0; i < students.size(); i++) {
				if(i==0) {
					criterion = RestrictionsFactoryUtil.like("userId", students.get(i).getUserId());
				} else {
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("userId", students.get(i).getUserId()));
				}
			}
			if(Validator.isNotNull(criterion)) {
				criterion=RestrictionsFactoryUtil.and(criterion,
						RestrictionsFactoryUtil.eq("passed",new Boolean (false)));

				consulta.add(criterion);

				criterion=PropertyFactoryUtil.forName("endDate").isNotNull();
				consulta.add(criterion);

				List<LearningActivityResult> results = learningActivityResultPersistence.findWithDynamicQuery(consulta);
				if(results!=null && !results.isEmpty()) {
					res = results.size();
				}
			}
		}

		return res;
	}

	public Double avgResult(long actId) throws SystemException
	{
		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader"); 
		DynamicQuery dq=DynamicQueryFactoryUtil.forClass(LearningActivityResult.class, classLoader);
		Criterion criterion=PropertyFactoryUtil.forName("actId").eq(actId);
		dq.add(criterion);
		criterion=PropertyFactoryUtil.forName("endDate").isNotNull();
		dq.add(criterion);
		dq.setProjection(ProjectionFactoryUtil.avg("result"));
		return (Double)(learningActivityResultPersistence.findWithDynamicQuery(dq).get(0));
	}

	public Double avgResultOnlyStudents(long actId, long companyId, long courseGropupCreatedId) throws SystemException {
		return avgResultOnlyStudents(actId, companyId, courseGropupCreatedId, null);
	}

	public Double avgResultOnlyStudents(long actId, long companyId, long courseGropupCreatedId, List<User> _students) throws SystemException
	{
		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader"); 
		DynamicQuery dq=DynamicQueryFactoryUtil.forClass(LearningActivityResult.class, classLoader);
		Criterion criterion=PropertyFactoryUtil.forName("actId").eq(actId);
		dq.add(criterion);
		criterion=PropertyFactoryUtil.forName("endDate").isNotNull();
		dq.add(criterion);

		List<User> students = null;
		// Se prepara el metodo para recibir un Listado de estudiantes especificos,, por ejemplo que pertenezcan a alguna organizacion. Sino, se trabaja con todos los estudiantes del curso.
		if(Validator.isNotNull(_students) && _students.size() > 0)
			students = _students;
		else
			students = CourseLocalServiceUtil.getStudentsFromCourse(companyId, courseGropupCreatedId);

		if(Validator.isNotNull(students) && students.size() > 0) {
			for (int i = 0; i < students.size(); i++) {
				if(i==0) {
					criterion = RestrictionsFactoryUtil.like("userId", students.get(i).getUserId());
				} else {
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("userId", students.get(i).getUserId()));
				}
			}
		}
		dq.add(criterion);

		dq.setProjection(ProjectionFactoryUtil.avg("result"));
		return (Double)(learningActivityResultPersistence.findWithDynamicQuery(dq).get(0));
	}

	public long countStarted(long actId) throws SystemException
	{
		return learningActivityResultPersistence.countByac(actId);
	}

	public long countStartedOnlyStudents(long actId, long companyId, long courseGropupCreatedId) throws SystemException{
		return countStartedOnlyStudents(actId, companyId, courseGropupCreatedId, null);
	}

	public long countStartedOnlyStudents(long actId, long companyId, long courseGropupCreatedId, List<User> _students) throws SystemException
	{
		long res = 0;

		try {
			List<User> students = null;
			// Se prepara el metodo para recibir un Listado de estudiantes especificos,, por ejemplo que pertenezcan a alguna organizacion. Sino, se trabaja con todos los estudiantes del curso.
			if(Validator.isNotNull(_students) && _students.size() > 0)
				students = _students;
			else
				students = CourseLocalServiceUtil.getStudentsFromCourse(companyId, courseGropupCreatedId);

			ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
			DynamicQuery consulta = DynamicQueryFactoryUtil.forClass(LearningActivityResult.class, classLoader)
					.add(PropertyFactoryUtil.forName("actId").eq(actId));

			if(Validator.isNotNull(students) && students.size() > 0) {
				Criterion criterion = null;
				for (int i = 0; i < students.size(); i++) {
					if(i==0) {
						criterion = RestrictionsFactoryUtil.like("userId", students.get(i).getUserId());
					} else {
						criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("userId", students.get(i).getUserId()));
					}
				}
				if(Validator.isNotNull(criterion)) {
					consulta.add(criterion);

					List<LearningActivityResult> results = learningActivityResultPersistence.findWithDynamicQuery(consulta);
					if(results!=null && !results.isEmpty()) {
						res = results.size();
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;


		//return learningActivityResultPersistence.countByac(actId);
	}

	public double triesPerUser(long actId) throws SystemException
	{
		long tries=learningActivityTryPersistence.countByact(actId);
		long started=countStarted(actId);
		if(started==0)
		{
			return 0;
		}
		return ((double) tries)/((double) started);
	}

	public double triesPerUserOnlyStudents(long actId, long companyId, long courseGropupCreatedId) throws SystemException {
		return triesPerUserOnlyStudents(actId, companyId, courseGropupCreatedId, null);
	}


	public double triesPerUserOnlyStudents(long actId, long companyId, long courseGropupCreatedId, List<User> _students) throws SystemException
	{
		long tries=0;
		List<User> students = null;
		// Se prepara el metodo para recibir un Listado de estudiantes especificos,, por ejemplo que pertenezcan a alguna organizacion. Sino, se trabaja con todos los estudiantes del curso.
		if(Validator.isNotNull(_students) && _students.size() > 0)
			students = _students;
		else
			students = CourseLocalServiceUtil.getStudentsFromCourse(companyId, courseGropupCreatedId);

		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
		DynamicQuery consulta = DynamicQueryFactoryUtil.forClass(LearningActivityTry.class, classLoader)
				.add(PropertyFactoryUtil.forName("actId").eq(actId));

		if(Validator.isNotNull(students) && students.size() > 0) {
			Criterion criterion = null;
			for (int i = 0; i < students.size(); i++) {
				if(i==0) {
					criterion = RestrictionsFactoryUtil.like("userId", students.get(i).getUserId());
				} else {
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("userId", students.get(i).getUserId()));
				}
			}
			if(Validator.isNotNull(criterion)) {
				consulta.add(criterion);

				List<LearningActivityTry> results = learningActivityTryPersistence.findWithDynamicQuery(consulta);
				if(results!=null && !results.isEmpty()) {
					tries = results.size();
				}
			}
		}

		long started=countStartedOnlyStudents(actId, companyId, courseGropupCreatedId, null);
		if(started==0)
		{
			return 0;
		}
		return ((double) tries)/((double) started);
	}

	public LearningActivityResult getByActIdAndUserId(long actId,long userId) throws SystemException{
		return learningActivityResultPersistence.fetchByact_user(actId, userId);
	}

	public Date getLastEndDateByUserId(long userId) throws SystemException{
		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader"); 
		DynamicQuery dq=DynamicQueryFactoryUtil.forClass(LearningActivityResult.class, classLoader);
		Criterion criterion=PropertyFactoryUtil.forName("userId").eq(userId);
		dq.add(criterion);
		criterion=PropertyFactoryUtil.forName("endDate").isNotNull();
		dq.add(criterion);
		dq.setProjection(ProjectionFactoryUtil.max("endDate"));
		return (Date)(learningActivityResultPersistence.findWithDynamicQuery(dq).get(0));
	}

	public List<LearningActivityResult> getByActId(long actId){
		List<LearningActivityResult> results = new ArrayList<LearningActivityResult>();
		try {
			results = learningActivityResultPersistence.findByac(actId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return results;			
	}

	public List<LearningActivityResult> getByGroupIdUserId(long groupId,long userId){
		List<LearningActivityResult> results = new ArrayList<LearningActivityResult>();

		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader"); 
		DynamicQuery dq2 = DynamicQueryFactoryUtil.forClass(LearningActivity.class, classLoader)
				.add(PropertyFactoryUtil.forName("groupId").eq(groupId))
				.setProjection(ProjectionFactoryUtil.property("actId"));

		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(LearningActivityResult.class, classLoader)
				.add(PropertyFactoryUtil.forName("userId").eq(userId))
				.add(PropertyFactoryUtil.forName("actId").in(dq2));		

		try {
			results = (List<LearningActivityResult>)learningActivityResultPersistence.findWithDynamicQuery(dq);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		log.debug("::getByModuleId:"+results.size());
		return results;			
	}

	public List<LearningActivityResult> getMandatoryByGroupIdUserId(long groupId,long userId){
		List<LearningActivityResult> results = new ArrayList<LearningActivityResult>();

		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader"); 
		DynamicQuery dq2 = DynamicQueryFactoryUtil.forClass(LearningActivity.class, classLoader)
				.add(PropertyFactoryUtil.forName("groupId").eq(groupId))
				.add(PropertyFactoryUtil.forName("weightinmodule").gt(0L))
				.setProjection(ProjectionFactoryUtil.property("actId"));

		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(LearningActivityResult.class, classLoader)
				.add(PropertyFactoryUtil.forName("userId").eq(userId))
				.add(PropertyFactoryUtil.forName("actId").in(dq2));

		try {
			results = (List<LearningActivityResult>)learningActivityResultPersistence.findWithDynamicQuery(dq);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		log.debug("::getByModuleIdPassed:"+results.size());
		return results;			
	}

	public List<LearningActivityResult> getByModuleIdUserId(long moduleId,long userId){
		List<LearningActivityResult> results = new ArrayList<LearningActivityResult>();

		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader"); 
		DynamicQuery dq2 = DynamicQueryFactoryUtil.forClass(LearningActivity.class, classLoader)
				.add(PropertyFactoryUtil.forName("moduleId").eq(moduleId))
				.setProjection(ProjectionFactoryUtil.property("actId"));

		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(LearningActivityResult.class, classLoader)
				.add(PropertyFactoryUtil.forName("userId").eq(userId))
				.add(PropertyFactoryUtil.forName("actId").in(dq2));		

		try {
			results = (List<LearningActivityResult>)learningActivityResultPersistence.findWithDynamicQuery(dq);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		log.debug("::getByModuleId:"+results.size());
		return results;			
	}

	public List<LearningActivityResult> getByModuleIdUserIdPassed(long moduleId,long userId){
		List<LearningActivityResult> results = new ArrayList<LearningActivityResult>();

		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader"); 
		DynamicQuery dq2 = DynamicQueryFactoryUtil.forClass(LearningActivity.class, classLoader)
				.add(PropertyFactoryUtil.forName("moduleId").eq(moduleId))
				.setProjection(ProjectionFactoryUtil.property("actId"));

		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(LearningActivityResult.class, classLoader)
				.add(PropertyFactoryUtil.forName("userId").eq(userId))
				.add(PropertyFactoryUtil.forName("passed").eq(true))
				.add(PropertyFactoryUtil.forName("actId").in(dq2));


		try {
			results = (List<LearningActivityResult>)learningActivityResultPersistence.findWithDynamicQuery(dq);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		log.debug("::getByModuleIdPassed:"+results.size());
		return results;			
	}

	public List<LearningActivityResult> getMandatoryByModuleIdUserIdPassed(long moduleId,long userId){
		List<LearningActivityResult> results = new ArrayList<LearningActivityResult>();

		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader"); 
		DynamicQuery dq2 = DynamicQueryFactoryUtil.forClass(LearningActivity.class, classLoader)
				.add(PropertyFactoryUtil.forName("moduleId").eq(moduleId))
				.add(PropertyFactoryUtil.forName("weightinmodule").gt(0L))
				.setProjection(ProjectionFactoryUtil.property("actId"));

		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(LearningActivityResult.class, classLoader)
				.add(PropertyFactoryUtil.forName("userId").eq(userId))
				.add(PropertyFactoryUtil.forName("passed").eq(true))
				.add(PropertyFactoryUtil.forName("actId").in(dq2));


		try {
			results = (List<LearningActivityResult>)learningActivityResultPersistence.findWithDynamicQuery(dq);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		log.debug("::getByModuleIdPassed:"+results.size());
		return results;			
	}

	public List<LearningActivityResult> getByUserId(long userId){
		List<LearningActivityResult> results = new ArrayList<LearningActivityResult>();
		try {
			results = learningActivityResultPersistence.findByuser(userId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return results;			
	}
	
	public int countMandatoryByModuleIdUserIdPassed(long moduleId,long userId){

		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader"); 
		DynamicQuery dq2 = DynamicQueryFactoryUtil.forClass(LearningActivity.class, classLoader)
				.add(PropertyFactoryUtil.forName("moduleId").eq(moduleId))
				.add(PropertyFactoryUtil.forName("weightinmodule").gt(0L))
				.setProjection(ProjectionFactoryUtil.property("actId"));

		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(LearningActivityResult.class, classLoader)
				.add(PropertyFactoryUtil.forName("userId").eq(userId))
				.add(PropertyFactoryUtil.forName("passed").eq(true))
				.add(PropertyFactoryUtil.forName("actId").in(dq2));


		try {
			return (int) LearningActivityResultLocalServiceUtil.dynamicQueryCount(dq);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return 0;			
	}

	public String translateResult(Locale locale, double result, long groupId){
		String translatedResult = "";
		try {
			Course curso = courseLocalService.getCourseByGroupCreatedId(groupId);
			if(curso != null){
				CalificationType ct = new CalificationTypeRegistry().getCalificationType(curso.getCalificationType());
				translatedResult = ct.translate(locale, result);
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return translatedResult;
	}
}