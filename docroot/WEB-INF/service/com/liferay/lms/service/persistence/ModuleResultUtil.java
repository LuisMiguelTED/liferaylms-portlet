/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.lms.service.persistence;

import com.liferay.lms.model.ModuleResult;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the module result service. This utility wraps {@link ModuleResultPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author TLS
 * @see ModuleResultPersistence
 * @see ModuleResultPersistenceImpl
 * @generated
 */
public class ModuleResultUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ModuleResult moduleResult) {
		getPersistence().clearCache(moduleResult);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ModuleResult> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ModuleResult> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ModuleResult> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ModuleResult update(ModuleResult moduleResult, boolean merge)
		throws SystemException {
		return getPersistence().update(moduleResult, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ModuleResult update(ModuleResult moduleResult, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(moduleResult, merge, serviceContext);
	}

	/**
	* Caches the module result in the entity cache if it is enabled.
	*
	* @param moduleResult the module result
	*/
	public static void cacheResult(
		com.liferay.lms.model.ModuleResult moduleResult) {
		getPersistence().cacheResult(moduleResult);
	}

	/**
	* Caches the module results in the entity cache if it is enabled.
	*
	* @param moduleResults the module results
	*/
	public static void cacheResult(
		java.util.List<com.liferay.lms.model.ModuleResult> moduleResults) {
		getPersistence().cacheResult(moduleResults);
	}

	/**
	* Creates a new module result with the primary key. Does not add the module result to the database.
	*
	* @param mrId the primary key for the new module result
	* @return the new module result
	*/
	public static com.liferay.lms.model.ModuleResult create(long mrId) {
		return getPersistence().create(mrId);
	}

	/**
	* Removes the module result with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mrId the primary key of the module result
	* @return the module result that was removed
	* @throws com.liferay.lms.NoSuchModuleResultException if a module result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult remove(long mrId)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(mrId);
	}

	public static com.liferay.lms.model.ModuleResult updateImpl(
		com.liferay.lms.model.ModuleResult moduleResult, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(moduleResult, merge);
	}

	/**
	* Returns the module result with the primary key or throws a {@link com.liferay.lms.NoSuchModuleResultException} if it could not be found.
	*
	* @param mrId the primary key of the module result
	* @return the module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a module result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByPrimaryKey(long mrId)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(mrId);
	}

	/**
	* Returns the module result with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mrId the primary key of the module result
	* @return the module result, or <code>null</code> if a module result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByPrimaryKey(
		long mrId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(mrId);
	}

	/**
	* Returns the module result where userId = &#63; and moduleId = &#63; or throws a {@link com.liferay.lms.NoSuchModuleResultException} if it could not be found.
	*
	* @param userId the user ID
	* @param moduleId the module ID
	* @return the matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findBymu(long userId,
		long moduleId)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymu(userId, moduleId);
	}

	/**
	* Returns the module result where userId = &#63; and moduleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param moduleId the module ID
	* @return the matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchBymu(long userId,
		long moduleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBymu(userId, moduleId);
	}

	/**
	* Returns the module result where userId = &#63; and moduleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param moduleId the module ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchBymu(long userId,
		long moduleId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBymu(userId, moduleId, retrieveFromCache);
	}

	/**
	* Returns all the module results where moduleId = &#63;.
	*
	* @param moduleId the module ID
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findBym(
		long moduleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBym(moduleId);
	}

	/**
	* Returns a range of all the module results where moduleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findBym(
		long moduleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBym(moduleId, start, end);
	}

	/**
	* Returns an ordered range of all the module results where moduleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findBym(
		long moduleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBym(moduleId, start, end, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63;.
	*
	* @param moduleId the module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findBym_First(
		long moduleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBym_First(moduleId, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63;.
	*
	* @param moduleId the module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchBym_First(
		long moduleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBym_First(moduleId, orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63;.
	*
	* @param moduleId the module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findBym_Last(
		long moduleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBym_Last(moduleId, orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63;.
	*
	* @param moduleId the module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchBym_Last(
		long moduleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBym_Last(moduleId, orderByComparator);
	}

	/**
	* Returns the module results before and after the current module result in the ordered set where moduleId = &#63;.
	*
	* @param mrId the primary key of the current module result
	* @param moduleId the module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a module result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult[] findBym_PrevAndNext(
		long mrId, long moduleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBym_PrevAndNext(mrId, moduleId, orderByComparator);
	}

	/**
	* Returns all the module results where moduleId = &#63; and passed = &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findBymp(
		long moduleId, boolean passed)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymp(moduleId, passed);
	}

	/**
	* Returns a range of all the module results where moduleId = &#63; and passed = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findBymp(
		long moduleId, boolean passed, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymp(moduleId, passed, start, end);
	}

	/**
	* Returns an ordered range of all the module results where moduleId = &#63; and passed = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findBymp(
		long moduleId, boolean passed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymp(moduleId, passed, start, end, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and passed = &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findBymp_First(
		long moduleId, boolean passed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymp_First(moduleId, passed, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and passed = &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchBymp_First(
		long moduleId, boolean passed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBymp_First(moduleId, passed, orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and passed = &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findBymp_Last(
		long moduleId, boolean passed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymp_Last(moduleId, passed, orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and passed = &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchBymp_Last(
		long moduleId, boolean passed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBymp_Last(moduleId, passed, orderByComparator);
	}

	/**
	* Returns the module results before and after the current module result in the ordered set where moduleId = &#63; and passed = &#63;.
	*
	* @param mrId the primary key of the current module result
	* @param moduleId the module ID
	* @param passed the passed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a module result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult[] findBymp_PrevAndNext(
		long mrId, long moduleId, boolean passed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymp_PrevAndNext(mrId, moduleId, passed,
			orderByComparator);
	}

	/**
	* Returns all the module results where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the module results where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the module results where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the module results before and after the current module result in the ordered set where userId = &#63;.
	*
	* @param mrId the primary key of the current module result
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a module result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult[] findByUserId_PrevAndNext(
		long mrId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_PrevAndNext(mrId, userId, orderByComparator);
	}

	/**
	* Returns all the module results where moduleId = &#63; and userId = &#63;.
	*
	* @param moduleId the module ID
	* @param userId the user ID
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdMultipleUserId(
		long moduleId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByModuleIdMultipleUserId(moduleId, userId);
	}

	/**
	* Returns a range of all the module results where moduleId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param userId the user ID
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdMultipleUserId(
		long moduleId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdMultipleUserId(moduleId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the module results where moduleId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param userId the user ID
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdMultipleUserId(
		long moduleId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdMultipleUserId(moduleId, userId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and userId = &#63;.
	*
	* @param moduleId the module ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByModuleIdMultipleUserId_First(
		long moduleId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdMultipleUserId_First(moduleId, userId,
			orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and userId = &#63;.
	*
	* @param moduleId the module ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByModuleIdMultipleUserId_First(
		long moduleId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdMultipleUserId_First(moduleId, userId,
			orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and userId = &#63;.
	*
	* @param moduleId the module ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByModuleIdMultipleUserId_Last(
		long moduleId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdMultipleUserId_Last(moduleId, userId,
			orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and userId = &#63;.
	*
	* @param moduleId the module ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByModuleIdMultipleUserId_Last(
		long moduleId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdMultipleUserId_Last(moduleId, userId,
			orderByComparator);
	}

	/**
	* Returns the module results before and after the current module result in the ordered set where moduleId = &#63; and userId = &#63;.
	*
	* @param mrId the primary key of the current module result
	* @param moduleId the module ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a module result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult[] findByModuleIdMultipleUserId_PrevAndNext(
		long mrId, long moduleId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdMultipleUserId_PrevAndNext(mrId, moduleId,
			userId, orderByComparator);
	}

	/**
	* Returns all the module results where moduleId = &#63; and userId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param userIds the user IDs
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdMultipleUserId(
		long moduleId, long[] userIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByModuleIdMultipleUserId(moduleId, userIds);
	}

	/**
	* Returns a range of all the module results where moduleId = &#63; and userId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param userIds the user IDs
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdMultipleUserId(
		long moduleId, long[] userIds, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdMultipleUserId(moduleId, userIds, start, end);
	}

	/**
	* Returns an ordered range of all the module results where moduleId = &#63; and userId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param userIds the user IDs
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdMultipleUserId(
		long moduleId, long[] userIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdMultipleUserId(moduleId, userIds, start, end,
			orderByComparator);
	}

	/**
	* Returns all the module results where moduleId = &#63; and passed = &#63; and userId = &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedMultipleUserId(
		long moduleId, boolean passed, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedMultipleUserId(moduleId, passed, userId);
	}

	/**
	* Returns a range of all the module results where moduleId = &#63; and passed = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedMultipleUserId(
		long moduleId, boolean passed, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedMultipleUserId(moduleId, passed,
			userId, start, end);
	}

	/**
	* Returns an ordered range of all the module results where moduleId = &#63; and passed = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedMultipleUserId(
		long moduleId, boolean passed, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedMultipleUserId(moduleId, passed,
			userId, start, end, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and passed = &#63; and userId = &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByModuleIdPassedMultipleUserId_First(
		long moduleId, boolean passed, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedMultipleUserId_First(moduleId, passed,
			userId, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and passed = &#63; and userId = &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByModuleIdPassedMultipleUserId_First(
		long moduleId, boolean passed, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdPassedMultipleUserId_First(moduleId, passed,
			userId, orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and passed = &#63; and userId = &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByModuleIdPassedMultipleUserId_Last(
		long moduleId, boolean passed, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedMultipleUserId_Last(moduleId, passed,
			userId, orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and passed = &#63; and userId = &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByModuleIdPassedMultipleUserId_Last(
		long moduleId, boolean passed, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdPassedMultipleUserId_Last(moduleId, passed,
			userId, orderByComparator);
	}

	/**
	* Returns the module results before and after the current module result in the ordered set where moduleId = &#63; and passed = &#63; and userId = &#63;.
	*
	* @param mrId the primary key of the current module result
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a module result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult[] findByModuleIdPassedMultipleUserId_PrevAndNext(
		long mrId, long moduleId, boolean passed, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedMultipleUserId_PrevAndNext(mrId,
			moduleId, passed, userId, orderByComparator);
	}

	/**
	* Returns all the module results where moduleId = &#63; and passed = &#63; and userId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userIds the user IDs
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedMultipleUserId(
		long moduleId, boolean passed, long[] userIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedMultipleUserId(moduleId, passed, userIds);
	}

	/**
	* Returns a range of all the module results where moduleId = &#63; and passed = &#63; and userId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userIds the user IDs
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedMultipleUserId(
		long moduleId, boolean passed, long[] userIds, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedMultipleUserId(moduleId, passed,
			userIds, start, end);
	}

	/**
	* Returns an ordered range of all the module results where moduleId = &#63; and passed = &#63; and userId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userIds the user IDs
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedMultipleUserId(
		long moduleId, boolean passed, long[] userIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedMultipleUserId(moduleId, passed,
			userIds, start, end, orderByComparator);
	}

	/**
	* Returns all the module results where moduleId = &#63; and passedDate IS NOT &#63; and userId = &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdMultipleUserIdFinished(
		long moduleId, java.util.Date passedDate, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdMultipleUserIdFinished(moduleId, passedDate,
			userId);
	}

	/**
	* Returns a range of all the module results where moduleId = &#63; and passedDate IS NOT &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdMultipleUserIdFinished(
		long moduleId, java.util.Date passedDate, long userId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdMultipleUserIdFinished(moduleId, passedDate,
			userId, start, end);
	}

	/**
	* Returns an ordered range of all the module results where moduleId = &#63; and passedDate IS NOT &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdMultipleUserIdFinished(
		long moduleId, java.util.Date passedDate, long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdMultipleUserIdFinished(moduleId, passedDate,
			userId, start, end, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and passedDate IS NOT &#63; and userId = &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByModuleIdMultipleUserIdFinished_First(
		long moduleId, java.util.Date passedDate, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdMultipleUserIdFinished_First(moduleId,
			passedDate, userId, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and passedDate IS NOT &#63; and userId = &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByModuleIdMultipleUserIdFinished_First(
		long moduleId, java.util.Date passedDate, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdMultipleUserIdFinished_First(moduleId,
			passedDate, userId, orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and passedDate IS NOT &#63; and userId = &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByModuleIdMultipleUserIdFinished_Last(
		long moduleId, java.util.Date passedDate, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdMultipleUserIdFinished_Last(moduleId,
			passedDate, userId, orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and passedDate IS NOT &#63; and userId = &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByModuleIdMultipleUserIdFinished_Last(
		long moduleId, java.util.Date passedDate, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdMultipleUserIdFinished_Last(moduleId,
			passedDate, userId, orderByComparator);
	}

	/**
	* Returns the module results before and after the current module result in the ordered set where moduleId = &#63; and passedDate IS NOT &#63; and userId = &#63;.
	*
	* @param mrId the primary key of the current module result
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a module result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult[] findByModuleIdMultipleUserIdFinished_PrevAndNext(
		long mrId, long moduleId, java.util.Date passedDate, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdMultipleUserIdFinished_PrevAndNext(mrId,
			moduleId, passedDate, userId, orderByComparator);
	}

	/**
	* Returns all the module results where moduleId = &#63; and passedDate IS NOT &#63; and userId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userIds the user IDs
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdMultipleUserIdFinished(
		long moduleId, java.util.Date passedDate, long[] userIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdMultipleUserIdFinished(moduleId, passedDate,
			userIds);
	}

	/**
	* Returns a range of all the module results where moduleId = &#63; and passedDate IS NOT &#63; and userId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userIds the user IDs
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdMultipleUserIdFinished(
		long moduleId, java.util.Date passedDate, long[] userIds, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdMultipleUserIdFinished(moduleId, passedDate,
			userIds, start, end);
	}

	/**
	* Returns an ordered range of all the module results where moduleId = &#63; and passedDate IS NOT &#63; and userId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userIds the user IDs
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdMultipleUserIdFinished(
		long moduleId, java.util.Date passedDate, long[] userIds, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdMultipleUserIdFinished(moduleId, passedDate,
			userIds, start, end, orderByComparator);
	}

	/**
	* Returns all the module results where moduleId = &#63; and passedDate IS NOT &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdFinished(
		long moduleId, java.util.Date passedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByModuleIdFinished(moduleId, passedDate);
	}

	/**
	* Returns a range of all the module results where moduleId = &#63; and passedDate IS NOT &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdFinished(
		long moduleId, java.util.Date passedDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdFinished(moduleId, passedDate, start, end);
	}

	/**
	* Returns an ordered range of all the module results where moduleId = &#63; and passedDate IS NOT &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdFinished(
		long moduleId, java.util.Date passedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdFinished(moduleId, passedDate, start, end,
			orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and passedDate IS NOT &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByModuleIdFinished_First(
		long moduleId, java.util.Date passedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdFinished_First(moduleId, passedDate,
			orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and passedDate IS NOT &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByModuleIdFinished_First(
		long moduleId, java.util.Date passedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdFinished_First(moduleId, passedDate,
			orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and passedDate IS NOT &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByModuleIdFinished_Last(
		long moduleId, java.util.Date passedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdFinished_Last(moduleId, passedDate,
			orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and passedDate IS NOT &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByModuleIdFinished_Last(
		long moduleId, java.util.Date passedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdFinished_Last(moduleId, passedDate,
			orderByComparator);
	}

	/**
	* Returns the module results before and after the current module result in the ordered set where moduleId = &#63; and passedDate IS NOT &#63;.
	*
	* @param mrId the primary key of the current module result
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a module result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult[] findByModuleIdFinished_PrevAndNext(
		long mrId, long moduleId, java.util.Date passedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdFinished_PrevAndNext(mrId, moduleId,
			passedDate, orderByComparator);
	}

	/**
	* Returns all the module results where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedFinished(
		long moduleId, boolean passed, java.util.Date passedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedFinished(moduleId, passed, passedDate);
	}

	/**
	* Returns a range of all the module results where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedFinished(
		long moduleId, boolean passed, java.util.Date passedDate, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedFinished(moduleId, passed, passedDate,
			start, end);
	}

	/**
	* Returns an ordered range of all the module results where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedFinished(
		long moduleId, boolean passed, java.util.Date passedDate, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedFinished(moduleId, passed, passedDate,
			start, end, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByModuleIdPassedFinished_First(
		long moduleId, boolean passed, java.util.Date passedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedFinished_First(moduleId, passed,
			passedDate, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByModuleIdPassedFinished_First(
		long moduleId, boolean passed, java.util.Date passedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdPassedFinished_First(moduleId, passed,
			passedDate, orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByModuleIdPassedFinished_Last(
		long moduleId, boolean passed, java.util.Date passedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedFinished_Last(moduleId, passed,
			passedDate, orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByModuleIdPassedFinished_Last(
		long moduleId, boolean passed, java.util.Date passedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdPassedFinished_Last(moduleId, passed,
			passedDate, orderByComparator);
	}

	/**
	* Returns the module results before and after the current module result in the ordered set where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63;.
	*
	* @param mrId the primary key of the current module result
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a module result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult[] findByModuleIdPassedFinished_PrevAndNext(
		long mrId, long moduleId, boolean passed, java.util.Date passedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedFinished_PrevAndNext(mrId, moduleId,
			passed, passedDate, orderByComparator);
	}

	/**
	* Returns all the module results where moduleId = &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param userId the user ID
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdNotMultipleUserId(
		long moduleId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByModuleIdNotMultipleUserId(moduleId, userId);
	}

	/**
	* Returns a range of all the module results where moduleId = &#63; and userId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param userId the user ID
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdNotMultipleUserId(
		long moduleId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdNotMultipleUserId(moduleId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the module results where moduleId = &#63; and userId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param userId the user ID
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdNotMultipleUserId(
		long moduleId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdNotMultipleUserId(moduleId, userId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByModuleIdNotMultipleUserId_First(
		long moduleId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdNotMultipleUserId_First(moduleId, userId,
			orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByModuleIdNotMultipleUserId_First(
		long moduleId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdNotMultipleUserId_First(moduleId, userId,
			orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByModuleIdNotMultipleUserId_Last(
		long moduleId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdNotMultipleUserId_Last(moduleId, userId,
			orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByModuleIdNotMultipleUserId_Last(
		long moduleId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdNotMultipleUserId_Last(moduleId, userId,
			orderByComparator);
	}

	/**
	* Returns the module results before and after the current module result in the ordered set where moduleId = &#63; and userId &ne; &#63;.
	*
	* @param mrId the primary key of the current module result
	* @param moduleId the module ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a module result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult[] findByModuleIdNotMultipleUserId_PrevAndNext(
		long mrId, long moduleId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdNotMultipleUserId_PrevAndNext(mrId, moduleId,
			userId, orderByComparator);
	}

	/**
	* Returns all the module results where moduleId = &#63; and userId &ne; all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param userIds the user IDs
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdNotMultipleUserId(
		long moduleId, long[] userIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdNotMultipleUserId(moduleId, userIds);
	}

	/**
	* Returns a range of all the module results where moduleId = &#63; and userId &ne; all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param userIds the user IDs
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdNotMultipleUserId(
		long moduleId, long[] userIds, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdNotMultipleUserId(moduleId, userIds, start,
			end);
	}

	/**
	* Returns an ordered range of all the module results where moduleId = &#63; and userId &ne; all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param userIds the user IDs
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdNotMultipleUserId(
		long moduleId, long[] userIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdNotMultipleUserId(moduleId, userIds, start,
			end, orderByComparator);
	}

	/**
	* Returns all the module results where moduleId = &#63; and passed = &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedNotMultipleUserId(
		long moduleId, boolean passed, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedNotMultipleUserId(moduleId, passed,
			userId);
	}

	/**
	* Returns a range of all the module results where moduleId = &#63; and passed = &#63; and userId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedNotMultipleUserId(
		long moduleId, boolean passed, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedNotMultipleUserId(moduleId, passed,
			userId, start, end);
	}

	/**
	* Returns an ordered range of all the module results where moduleId = &#63; and passed = &#63; and userId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedNotMultipleUserId(
		long moduleId, boolean passed, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedNotMultipleUserId(moduleId, passed,
			userId, start, end, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and passed = &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByModuleIdPassedNotMultipleUserId_First(
		long moduleId, boolean passed, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedNotMultipleUserId_First(moduleId,
			passed, userId, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and passed = &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByModuleIdPassedNotMultipleUserId_First(
		long moduleId, boolean passed, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdPassedNotMultipleUserId_First(moduleId,
			passed, userId, orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and passed = &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByModuleIdPassedNotMultipleUserId_Last(
		long moduleId, boolean passed, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedNotMultipleUserId_Last(moduleId,
			passed, userId, orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and passed = &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByModuleIdPassedNotMultipleUserId_Last(
		long moduleId, boolean passed, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdPassedNotMultipleUserId_Last(moduleId,
			passed, userId, orderByComparator);
	}

	/**
	* Returns the module results before and after the current module result in the ordered set where moduleId = &#63; and passed = &#63; and userId &ne; &#63;.
	*
	* @param mrId the primary key of the current module result
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a module result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult[] findByModuleIdPassedNotMultipleUserId_PrevAndNext(
		long mrId, long moduleId, boolean passed, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedNotMultipleUserId_PrevAndNext(mrId,
			moduleId, passed, userId, orderByComparator);
	}

	/**
	* Returns all the module results where moduleId = &#63; and passed = &#63; and userId &ne; all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userIds the user IDs
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedNotMultipleUserId(
		long moduleId, boolean passed, long[] userIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedNotMultipleUserId(moduleId, passed,
			userIds);
	}

	/**
	* Returns a range of all the module results where moduleId = &#63; and passed = &#63; and userId &ne; all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userIds the user IDs
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedNotMultipleUserId(
		long moduleId, boolean passed, long[] userIds, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedNotMultipleUserId(moduleId, passed,
			userIds, start, end);
	}

	/**
	* Returns an ordered range of all the module results where moduleId = &#63; and passed = &#63; and userId &ne; all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userIds the user IDs
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedNotMultipleUserId(
		long moduleId, boolean passed, long[] userIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedNotMultipleUserId(moduleId, passed,
			userIds, start, end, orderByComparator);
	}

	/**
	* Returns all the module results where moduleId = &#63; and passedDate IS NOT &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdNotMultipleUserIdFinished(
		long moduleId, java.util.Date passedDate, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdNotMultipleUserIdFinished(moduleId,
			passedDate, userId);
	}

	/**
	* Returns a range of all the module results where moduleId = &#63; and passedDate IS NOT &#63; and userId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdNotMultipleUserIdFinished(
		long moduleId, java.util.Date passedDate, long userId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdNotMultipleUserIdFinished(moduleId,
			passedDate, userId, start, end);
	}

	/**
	* Returns an ordered range of all the module results where moduleId = &#63; and passedDate IS NOT &#63; and userId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdNotMultipleUserIdFinished(
		long moduleId, java.util.Date passedDate, long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdNotMultipleUserIdFinished(moduleId,
			passedDate, userId, start, end, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and passedDate IS NOT &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByModuleIdNotMultipleUserIdFinished_First(
		long moduleId, java.util.Date passedDate, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdNotMultipleUserIdFinished_First(moduleId,
			passedDate, userId, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and passedDate IS NOT &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByModuleIdNotMultipleUserIdFinished_First(
		long moduleId, java.util.Date passedDate, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdNotMultipleUserIdFinished_First(moduleId,
			passedDate, userId, orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and passedDate IS NOT &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByModuleIdNotMultipleUserIdFinished_Last(
		long moduleId, java.util.Date passedDate, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdNotMultipleUserIdFinished_Last(moduleId,
			passedDate, userId, orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and passedDate IS NOT &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByModuleIdNotMultipleUserIdFinished_Last(
		long moduleId, java.util.Date passedDate, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdNotMultipleUserIdFinished_Last(moduleId,
			passedDate, userId, orderByComparator);
	}

	/**
	* Returns the module results before and after the current module result in the ordered set where moduleId = &#63; and passedDate IS NOT &#63; and userId &ne; &#63;.
	*
	* @param mrId the primary key of the current module result
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a module result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult[] findByModuleIdNotMultipleUserIdFinished_PrevAndNext(
		long mrId, long moduleId, java.util.Date passedDate, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdNotMultipleUserIdFinished_PrevAndNext(mrId,
			moduleId, passedDate, userId, orderByComparator);
	}

	/**
	* Returns all the module results where moduleId = &#63; and passedDate IS NOT &#63; and userId &ne; all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userIds the user IDs
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdNotMultipleUserIdFinished(
		long moduleId, java.util.Date passedDate, long[] userIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdNotMultipleUserIdFinished(moduleId,
			passedDate, userIds);
	}

	/**
	* Returns a range of all the module results where moduleId = &#63; and passedDate IS NOT &#63; and userId &ne; all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userIds the user IDs
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdNotMultipleUserIdFinished(
		long moduleId, java.util.Date passedDate, long[] userIds, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdNotMultipleUserIdFinished(moduleId,
			passedDate, userIds, start, end);
	}

	/**
	* Returns an ordered range of all the module results where moduleId = &#63; and passedDate IS NOT &#63; and userId &ne; all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userIds the user IDs
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdNotMultipleUserIdFinished(
		long moduleId, java.util.Date passedDate, long[] userIds, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdNotMultipleUserIdFinished(moduleId,
			passedDate, userIds, start, end, orderByComparator);
	}

	/**
	* Returns all the module results where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param userId the user ID
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedNotMultipleUserIdFinished(
		long moduleId, boolean passed, java.util.Date passedDate, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedNotMultipleUserIdFinished(moduleId,
			passed, passedDate, userId);
	}

	/**
	* Returns a range of all the module results where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63; and userId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param userId the user ID
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedNotMultipleUserIdFinished(
		long moduleId, boolean passed, java.util.Date passedDate, long userId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedNotMultipleUserIdFinished(moduleId,
			passed, passedDate, userId, start, end);
	}

	/**
	* Returns an ordered range of all the module results where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63; and userId &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param userId the user ID
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedNotMultipleUserIdFinished(
		long moduleId, boolean passed, java.util.Date passedDate, long userId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedNotMultipleUserIdFinished(moduleId,
			passed, passedDate, userId, start, end, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByModuleIdPassedNotMultipleUserIdFinished_First(
		long moduleId, boolean passed, java.util.Date passedDate, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedNotMultipleUserIdFinished_First(moduleId,
			passed, passedDate, userId, orderByComparator);
	}

	/**
	* Returns the first module result in the ordered set where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByModuleIdPassedNotMultipleUserIdFinished_First(
		long moduleId, boolean passed, java.util.Date passedDate, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdPassedNotMultipleUserIdFinished_First(moduleId,
			passed, passedDate, userId, orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult findByModuleIdPassedNotMultipleUserIdFinished_Last(
		long moduleId, boolean passed, java.util.Date passedDate, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedNotMultipleUserIdFinished_Last(moduleId,
			passed, passedDate, userId, orderByComparator);
	}

	/**
	* Returns the last module result in the ordered set where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module result, or <code>null</code> if a matching module result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult fetchByModuleIdPassedNotMultipleUserIdFinished_Last(
		long moduleId, boolean passed, java.util.Date passedDate, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdPassedNotMultipleUserIdFinished_Last(moduleId,
			passed, passedDate, userId, orderByComparator);
	}

	/**
	* Returns the module results before and after the current module result in the ordered set where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63; and userId &ne; &#63;.
	*
	* @param mrId the primary key of the current module result
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module result
	* @throws com.liferay.lms.NoSuchModuleResultException if a module result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult[] findByModuleIdPassedNotMultipleUserIdFinished_PrevAndNext(
		long mrId, long moduleId, boolean passed, java.util.Date passedDate,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedNotMultipleUserIdFinished_PrevAndNext(mrId,
			moduleId, passed, passedDate, userId, orderByComparator);
	}

	/**
	* Returns all the module results where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63; and userId &ne; all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param userIds the user IDs
	* @return the matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedNotMultipleUserIdFinished(
		long moduleId, boolean passed, java.util.Date passedDate, long[] userIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedNotMultipleUserIdFinished(moduleId,
			passed, passedDate, userIds);
	}

	/**
	* Returns a range of all the module results where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63; and userId &ne; all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param userIds the user IDs
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedNotMultipleUserIdFinished(
		long moduleId, boolean passed, java.util.Date passedDate,
		long[] userIds, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedNotMultipleUserIdFinished(moduleId,
			passed, passedDate, userIds, start, end);
	}

	/**
	* Returns an ordered range of all the module results where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63; and userId &ne; all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param userIds the user IDs
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findByModuleIdPassedNotMultipleUserIdFinished(
		long moduleId, boolean passed, java.util.Date passedDate,
		long[] userIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdPassedNotMultipleUserIdFinished(moduleId,
			passed, passedDate, userIds, start, end, orderByComparator);
	}

	/**
	* Returns all the module results.
	*
	* @return the module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the module results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @return the range of module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the module results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of module results
	* @param end the upper bound of the range of module results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of module results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ModuleResult> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the module result where userId = &#63; and moduleId = &#63; from the database.
	*
	* @param userId the user ID
	* @param moduleId the module ID
	* @return the module result that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ModuleResult removeBymu(long userId,
		long moduleId)
		throws com.liferay.lms.NoSuchModuleResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeBymu(userId, moduleId);
	}

	/**
	* Removes all the module results where moduleId = &#63; from the database.
	*
	* @param moduleId the module ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBym(long moduleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBym(moduleId);
	}

	/**
	* Removes all the module results where moduleId = &#63; and passed = &#63; from the database.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBymp(long moduleId, boolean passed)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBymp(moduleId, passed);
	}

	/**
	* Removes all the module results where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the module results where moduleId = &#63; and userId = &#63; from the database.
	*
	* @param moduleId the module ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByModuleIdMultipleUserId(long moduleId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByModuleIdMultipleUserId(moduleId, userId);
	}

	/**
	* Removes all the module results where moduleId = &#63; and passed = &#63; and userId = &#63; from the database.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByModuleIdPassedMultipleUserId(long moduleId,
		boolean passed, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByModuleIdPassedMultipleUserId(moduleId, passed, userId);
	}

	/**
	* Removes all the module results where moduleId = &#63; and passedDate IS NOT &#63; and userId = &#63; from the database.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByModuleIdMultipleUserIdFinished(long moduleId,
		java.util.Date passedDate, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByModuleIdMultipleUserIdFinished(moduleId, passedDate, userId);
	}

	/**
	* Removes all the module results where moduleId = &#63; and passedDate IS NOT &#63; from the database.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByModuleIdFinished(long moduleId,
		java.util.Date passedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByModuleIdFinished(moduleId, passedDate);
	}

	/**
	* Removes all the module results where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63; from the database.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByModuleIdPassedFinished(long moduleId,
		boolean passed, java.util.Date passedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByModuleIdPassedFinished(moduleId, passed, passedDate);
	}

	/**
	* Removes all the module results where moduleId = &#63; and userId &ne; &#63; from the database.
	*
	* @param moduleId the module ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByModuleIdNotMultipleUserId(long moduleId,
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByModuleIdNotMultipleUserId(moduleId, userId);
	}

	/**
	* Removes all the module results where moduleId = &#63; and passed = &#63; and userId &ne; &#63; from the database.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByModuleIdPassedNotMultipleUserId(long moduleId,
		boolean passed, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByModuleIdPassedNotMultipleUserId(moduleId, passed, userId);
	}

	/**
	* Removes all the module results where moduleId = &#63; and passedDate IS NOT &#63; and userId &ne; &#63; from the database.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByModuleIdNotMultipleUserIdFinished(
		long moduleId, java.util.Date passedDate, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByModuleIdNotMultipleUserIdFinished(moduleId, passedDate,
			userId);
	}

	/**
	* Removes all the module results where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63; and userId &ne; &#63; from the database.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByModuleIdPassedNotMultipleUserIdFinished(
		long moduleId, boolean passed, java.util.Date passedDate, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByModuleIdPassedNotMultipleUserIdFinished(moduleId, passed,
			passedDate, userId);
	}

	/**
	* Removes all the module results from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of module results where userId = &#63; and moduleId = &#63;.
	*
	* @param userId the user ID
	* @param moduleId the module ID
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countBymu(long userId, long moduleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBymu(userId, moduleId);
	}

	/**
	* Returns the number of module results where moduleId = &#63;.
	*
	* @param moduleId the module ID
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countBym(long moduleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBym(moduleId);
	}

	/**
	* Returns the number of module results where moduleId = &#63; and passed = &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countBymp(long moduleId, boolean passed)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBymp(moduleId, passed);
	}

	/**
	* Returns the number of module results where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of module results where moduleId = &#63; and userId = &#63;.
	*
	* @param moduleId the module ID
	* @param userId the user ID
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleIdMultipleUserId(long moduleId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByModuleIdMultipleUserId(moduleId, userId);
	}

	/**
	* Returns the number of module results where moduleId = &#63; and userId = any &#63;.
	*
	* @param moduleId the module ID
	* @param userIds the user IDs
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleIdMultipleUserId(long moduleId,
		long[] userIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByModuleIdMultipleUserId(moduleId, userIds);
	}

	/**
	* Returns the number of module results where moduleId = &#63; and passed = &#63; and userId = &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleIdPassedMultipleUserId(long moduleId,
		boolean passed, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByModuleIdPassedMultipleUserId(moduleId, passed, userId);
	}

	/**
	* Returns the number of module results where moduleId = &#63; and passed = &#63; and userId = any &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userIds the user IDs
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleIdPassedMultipleUserId(long moduleId,
		boolean passed, long[] userIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByModuleIdPassedMultipleUserId(moduleId, passed,
			userIds);
	}

	/**
	* Returns the number of module results where moduleId = &#63; and passedDate IS NOT &#63; and userId = &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleIdMultipleUserIdFinished(long moduleId,
		java.util.Date passedDate, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByModuleIdMultipleUserIdFinished(moduleId, passedDate,
			userId);
	}

	/**
	* Returns the number of module results where moduleId = &#63; and passedDate IS NOT &#63; and userId = any &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userIds the user IDs
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleIdMultipleUserIdFinished(long moduleId,
		java.util.Date passedDate, long[] userIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByModuleIdMultipleUserIdFinished(moduleId, passedDate,
			userIds);
	}

	/**
	* Returns the number of module results where moduleId = &#63; and passedDate IS NOT &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleIdFinished(long moduleId,
		java.util.Date passedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByModuleIdFinished(moduleId, passedDate);
	}

	/**
	* Returns the number of module results where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleIdPassedFinished(long moduleId,
		boolean passed, java.util.Date passedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByModuleIdPassedFinished(moduleId, passed, passedDate);
	}

	/**
	* Returns the number of module results where moduleId = &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param userId the user ID
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleIdNotMultipleUserId(long moduleId,
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByModuleIdNotMultipleUserId(moduleId, userId);
	}

	/**
	* Returns the number of module results where moduleId = &#63; and userId &ne; all &#63;.
	*
	* @param moduleId the module ID
	* @param userIds the user IDs
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleIdNotMultipleUserId(long moduleId,
		long[] userIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByModuleIdNotMultipleUserId(moduleId, userIds);
	}

	/**
	* Returns the number of module results where moduleId = &#63; and passed = &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userId the user ID
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleIdPassedNotMultipleUserId(long moduleId,
		boolean passed, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByModuleIdPassedNotMultipleUserId(moduleId, passed,
			userId);
	}

	/**
	* Returns the number of module results where moduleId = &#63; and passed = &#63; and userId &ne; all &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param userIds the user IDs
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleIdPassedNotMultipleUserId(long moduleId,
		boolean passed, long[] userIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByModuleIdPassedNotMultipleUserId(moduleId, passed,
			userIds);
	}

	/**
	* Returns the number of module results where moduleId = &#63; and passedDate IS NOT &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userId the user ID
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleIdNotMultipleUserIdFinished(long moduleId,
		java.util.Date passedDate, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByModuleIdNotMultipleUserIdFinished(moduleId,
			passedDate, userId);
	}

	/**
	* Returns the number of module results where moduleId = &#63; and passedDate IS NOT &#63; and userId &ne; all &#63;.
	*
	* @param moduleId the module ID
	* @param passedDate the passed date
	* @param userIds the user IDs
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleIdNotMultipleUserIdFinished(long moduleId,
		java.util.Date passedDate, long[] userIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByModuleIdNotMultipleUserIdFinished(moduleId,
			passedDate, userIds);
	}

	/**
	* Returns the number of module results where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63; and userId &ne; &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param userId the user ID
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleIdPassedNotMultipleUserIdFinished(
		long moduleId, boolean passed, java.util.Date passedDate, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByModuleIdPassedNotMultipleUserIdFinished(moduleId,
			passed, passedDate, userId);
	}

	/**
	* Returns the number of module results where moduleId = &#63; and passed = &#63; and passedDate IS NOT &#63; and userId &ne; all &#63;.
	*
	* @param moduleId the module ID
	* @param passed the passed
	* @param passedDate the passed date
	* @param userIds the user IDs
	* @return the number of matching module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleIdPassedNotMultipleUserIdFinished(
		long moduleId, boolean passed, java.util.Date passedDate, long[] userIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByModuleIdPassedNotMultipleUserIdFinished(moduleId,
			passed, passedDate, userIds);
	}

	/**
	* Returns the number of module results.
	*
	* @return the number of module results
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ModuleResultPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ModuleResultPersistence)PortletBeanLocatorUtil.locate(com.liferay.lms.service.ClpSerializer.getServletContextName(),
					ModuleResultPersistence.class.getName());

			ReferenceRegistry.registerReference(ModuleResultUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ModuleResultPersistence persistence) {
	}

	private static ModuleResultPersistence _persistence;
}