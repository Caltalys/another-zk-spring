package vn.tcx.zk.module.user;

import java.util.HashMap;

import org.apache.shiro.realm.AuthorizingRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author caltalys
 */
public class Quyen extends HashMap<String, Boolean> {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(Quyen.class);
    
    public static final char COLON = ':';
    public static final char UNDERSCORE = '_';
    public static final String SEPARATOR = COLON + "";

    public static final String LIST = "_list";
    public static final String ADD = "_add";
    public static final String VIEW = "_view";
    public static final String EDIT = "_edit";
    public static final String DELETE = "_delete";
    
    private long id;
    private String resource = "";

    public Quyen(AuthorizingRealm realm) {
        this.realm = realm;
    }

    public Quyen(AuthorizingRealm realm, String resource) {
        this(realm);
        this.resource = resource;
    }

    public Quyen(AuthorizingRealm realm, String resource, long id) {
        this(realm, resource);
        this.resource = resource;
        this.id = id;
    }

    private transient AuthorizingRealm realm;

    public AuthorizingRealm getRealm() {
        return this.realm;
    }

    
    /* 
     * Check object has permission or not
     * @param key to check permission, 
     * format: Resource_Action_Object
     * example: nguoidung_chinhsua_1
     * @see java.util.HashMap#get(java.lang.Object)
     * @link https://shiro.apache.org/java-authorization-guide.html
     */
    @Override
    public Boolean get(Object key_) {
        log.debug("key_{}",key_);
        if (key_ == null) {
            return false;
        }
        String key = key_.toString();
        if (!key.isEmpty() && key.charAt(0) == UNDERSCORE) {
            key = resource + key;
        }
        if (id != 0) {
            key += SEPARATOR + id;
        }
        boolean result = false;
        if (realm != null) {
            result = realm.isPermitted(null, key.replace(UNDERSCORE, COLON));
        }
        return result;
    }

}