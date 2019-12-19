package com.sonan.math.util;

/**
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2019-12-13
 * @since: 1.8
 */
public class NullNotCalculateException extends RuntimeException {

  public NullNotCalculateException() {
    super();
  }

  public NullNotCalculateException(String message) {
    super(message);
  }

  public NullNotCalculateException(String message, Throwable cause) {
    super(message, cause);
  }

  public NullNotCalculateException(Throwable cause) {
    super(cause);
  }
}
