package vn.tcx.zk.module.log;

import java.util.List;

public interface LogService {

	Log addLog(Log log);

	List<Log> getLogs();

	void deleteLog(Log log);
}
