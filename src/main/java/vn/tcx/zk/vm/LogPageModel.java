/**
 * 
 */
package vn.tcx.zk.vm;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import vn.tcx.zk.module.log.Log;
import vn.tcx.zk.module.log.LogService;

/**
 * @author caltalys
 *
 */
@VariableResolver(DelegatingVariableResolver.class)
public class LogPageModel extends PageModel<Log>{

    @WireVariable
    private LogService logService;
    private ListModelList<Log> logListModel;
    private String message;

    /**
     * @param uri
     * @param model
     */
    public LogPageModel(String uri, Class<Log> clazz) {
        super(uri, clazz);
    }

    @Init
    public void init() {
        List<Log> logList = logService.getLogs();
        logListModel = new ListModelList<>(logList);
    }

    public ListModel<Log> getLogListModel() {
        return logListModel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Command
    public void addLog() {
        if(Strings.isBlank(message)) {
            return;
        }
        Log log = new Log(message);
        log = logService.addLog(log);
        logListModel.add(log);
    }

    @Command
    public void deleteLog(@BindingParam("log") Log log) {
        logService.deleteLog(log);
        logListModel.remove(log);
    }
}
