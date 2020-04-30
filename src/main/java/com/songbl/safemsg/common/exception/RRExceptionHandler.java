
package com.songbl.safemsg.common.exception;

import com.songbl.safemsg.common.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 异常处理器
 *1.@RestControllerAdvice（控制器增强）由下面两个注解：
 *  	@ControllerAdvice（含@Component）
 * 		@ResponseBody（这个异常的返回仍然是json数据）
 *
 *
 * 2. 我们自定义异常处理器，	实现HandlerExceptionResolver接口；扫描进入到Spring容器中就能工作
 * 这是为什么？ 处理器执行链有一次处理项，进而就执行我们定义的异常处理器
 *
 *
 */
//全局异常处理类
@RestControllerAdvice
public class RRExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 * @ExceptionHandler定义异常方法
	 */
	@ExceptionHandler(RRException.class)
	public R handleRRException(RRException e){
		R r = new R();
		r.put("code", e.getCode());
		r.put("msg", e.getMessage());

		return r;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public R handlerNoFoundException(Exception e) {
		logger.error(e.getMessage(), e);
		return R.error(404, "路径不存在，请检查路径是否正确");
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public R handleDuplicateKeyException(DuplicateKeyException e){
		logger.error(e.getMessage(), e);
		return R.error("数据库中已存在该记录");
	}



	@ExceptionHandler(Exception.class)
	public R handleException(Exception e){
		logger.error(e.getMessage(), e);
		return R.error();
	}
}
