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
    private Class<T> clazz;

    PageModel(String uri, Class<T> clazz) {
        this.uri = uri;
        this.clazz = clazz;
    }

    /**
     * @return the uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * @return the clazz
     */
    public Class<T> getClazz() {
        return clazz;
    }
}
