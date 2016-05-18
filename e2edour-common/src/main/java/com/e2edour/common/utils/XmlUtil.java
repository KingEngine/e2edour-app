//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.e2edour.common.utils;

import com.e2edour.common.cache.Cache;
import com.e2edour.common.cache.support.lru.LruCacheFactory;
import com.e2edour.common.exception.XmlParserException;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlUtil {
    private static Logger logger = LoggerFactory.getLogger(XmlUtil.class);
    private static XStream xstream = new XStream();
    private static XStream xstream2Xml = new XStream();
    private static Cache xstream2ObjMap = LruCacheFactory.getInstance().getCache("xstream2ObjMap", 100);

    public XmlUtil() {
    }

    private static synchronized XStream creat2ObjXStream(Class<?> clazz) {
        if(xstream2ObjMap.get(clazz) != null) {
            return (XStream)xstream2ObjMap.get(clazz);
        } else {
            XStream xstream2Obj = new XStream();
            xstream2Obj.processAnnotations(clazz);
            xstream2ObjMap.put(clazz, xstream2Obj);
            return xstream2Obj;
        }
    }

    public static <T> T toObject(String xml) throws XmlParserException {
        if(xml == null) {
            logger.warn("xml is null!");
            throw new XmlParserException("xml content is null");
        } else {
            try {
                Object object = xstream.fromXML(xml);
                return (T)object;
            } catch (RuntimeException var3) {
                logger.error("xml:" + xml, var3);
                throw new XmlParserException("xml:" + xml, var3);
            }
        }
    }

    public static String toXml(Object object) throws XmlParserException {
        if(object == null) {
            logger.warn("object is null!");
            throw new XmlParserException("object is null");
        } else {
            try {
                String xml = xstream.toXML(object);
                return xml;
            } catch (RuntimeException var3) {
                logger.error("object:" + object.getClass(), var3);
                throw new XmlParserException("object:" + object.getClass(), var3);
            }
        }
    }

    public static String toXmlByAnnotation(Object object) throws XmlParserException {
        if(object == null) {
            logger.warn("object is null!");
            throw new XmlParserException("object is null");
        } else {
            return xstream2Xml.toXML(object);
        }
    }

    public static <T> T toObjectByAnnotation(String xml, Class beanClass) throws XmlParserException {
        if(beanClass == null) {
            logger.warn("beanClasses is null!");
            return null;
        } else if(xml == null) {
            logger.warn("xml is null!");
            return null;
        } else {
            XStream xstream2Obj = (XStream)xstream2ObjMap.get(beanClass);
            if(xstream2Obj == null) {
                xstream2Obj = creat2ObjXStream(beanClass);
            }

            try {
                Object object = xstream2Obj.fromXML(xml);
                return (T)object;
            } catch (RuntimeException var5) {
                logger.error("xml:" + xml, var5);
                throw new XmlParserException("xml:" + xml, var5);
            }
        }
    }

    static {
        xstream2Xml.autodetectAnnotations(true);
    }
}
