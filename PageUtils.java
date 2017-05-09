package com.alc.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ofbiz.base.util.Debug;
import org.ofbiz.entity.GenericDelegator;
import org.ofbiz.entity.GenericEntityException;
import org.ofbiz.entity.GenericValue;
import org.ofbiz.entity.condition.EntityCondition;
import org.ofbiz.entity.transaction.TransactionUtil;
import org.ofbiz.entity.util.EntityFindOptions;
import org.ofbiz.entity.util.EntityListIterator;

public class PageUtils {
	private static String module=PageUtils.class.getName();
	public static EntityFindOptions getFindOptions() {
		EntityFindOptions opts = new EntityFindOptions();
		// 同一product可能存在于不同的category下，这里在首页获取时需要传递，若为空，限定distinct productid
		opts.setDistinct(true);// 去重
		opts.setSpecifyTypeAndConcur(true);
		opts.setResultSetConcurrency(EntityFindOptions.CONCUR_READ_ONLY);
		opts.setResultSetType(EntityFindOptions.TYPE_SCROLL_INSENSITIVE);
		return opts;
	}
	public static Map<String, Object> searchPageValus(
			GenericDelegator delegator, String entityName,
			List<EntityCondition> cons, Set<String> selectFields,
			List<String> orderBy, EntityFindOptions opts, int start,
			int viewSize) {
		EntityListIterator eli = null;
		List<GenericValue> values = null;
		Map<String, Object> map = new HashMap<String, Object>();
		//int start = (viewIndex - 1) * viewSize + 1;// 从1开始,viewIndex为页码
		int total = 0;
		try {
			TransactionUtil.begin();
			eli = delegator.find(entityName,
					cons!=null?EntityCondition.makeCondition(cons):null, null, selectFields,
					orderBy, opts);
			values = eli.getPartialList(start, viewSize);
			eli.last();
			total=eli.currentIndex();
			Debug.logInfo("total GenericValue size="+total, module);
		} catch (GenericEntityException e) {
			Debug.logError(e.getMessage().toString(), module);
		} finally {
			try {
				if (eli != null) {
					eli.close();
					eli = null;
				}
				TransactionUtil.commit();
			} catch (GenericEntityException e) {
				Debug.logError(e.getMessage().toString(), module);
			}
		}
		map.put("total", total);
		map.put("values", values);
		return map;
	}
}
