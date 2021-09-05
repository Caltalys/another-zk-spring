/**
 * 
 */
package vn.tcx.zk.vm;

/**
 * @author caltalys
 *
 */
abstract class PageModel<T> {

    private String uri;
    private String name;
    private String action;
    private Class<T> clazz;

    PageModel(String uri, String name, String action, Class<T> clazz) {
        this.uri = uri;
        this.name = name;
        this.action = action;;
        this.clazz = clazz;
    }

    /**
     * @return the uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return the clazz
     */
    public Class<T> getClazz() {
        return clazz;
    }
    
    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }
    
    /**
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }
}
