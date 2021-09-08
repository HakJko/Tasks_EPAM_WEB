package com.rd.epam.autotasks.scopes.config.justasecond;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JustSecondScope implements Scope {

    private final HolderTime holderTime = new HolderTime();

    private Map<String, Object> scopedObjects
            = Collections.synchronizedMap(new HashMap<>());
    private Map<String, Runnable> destructionCallbacks
            = Collections.synchronizedMap(new HashMap<>());

    @Override
    public Object get(String bean, ObjectFactory<?> objectFactory) {
        createObj(bean, objectFactory);
        if (!isActual(bean)) {
            holderTime.removeTimeBean(bean);
            remove(bean);
            createObj(bean, objectFactory);
        }
        return scopedObjects.get(bean);
    }

    private boolean isActual(String bean) {
        long borderLife = 1000;
        long currentTime = System.currentTimeMillis();
        return currentTime - holderTime.getTimeBean(bean) < borderLife;
    }

    private void createObj(String bean, ObjectFactory<?> objectFactory) {
        if (!scopedObjects.containsKey(bean)) {
            scopedObjects.put(bean, objectFactory.getObject());
            holderTime.setTimeBean(bean);
        }
    }

    @Override
    public Object remove(String bean) {
        destructionCallbacks.remove(bean);
        return scopedObjects.remove(bean);
    }

    @Override
    public void registerDestructionCallback(String bean, Runnable callback) {
        destructionCallbacks.put(bean, callback);
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return "justASecond";
    }

    private class HolderTime {
        private Map<String, Long> beanTimes = Collections.synchronizedMap(new HashMap<>());

        public Long getTimeBean(String bean) {
            return beanTimes.get(bean);
        }

        public void setTimeBean(String bean) {
            beanTimes.put(bean, System.currentTimeMillis());
        }

        public void removeTimeBean(String bean) {
            beanTimes.remove(bean);
        }

    }
}
