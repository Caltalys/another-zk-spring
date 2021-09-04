package vn.tcx.zk.module.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("logService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LogServiceImpl implements LogService {

	@Autowired
	LogDao dao;

	public Log addLog(Log log) {
		return dao.save(log);
	}

	public List<Log> getLogs() {
		return dao.queryAll();
	}

	public void deleteLog(Log log) {
		dao.delete(log);
	}

}
