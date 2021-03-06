/*
 * Copyright (c) 2011-2014 The original author or authors
 * ------------------------------------------------------
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 *     The Eclipse Public License is available at
 *     http://www.eclipse.org/legal/epl-v10.html
 *
 *     The Apache License v2.0 is available at
 *     http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.core.spi.metrics;

import io.vertx.core.net.SocketAddress;

/**
 * The datagram/udp metrics SPI which Vert.x will use to call when each event occurs pertaining to datagram sockets.
 *
 * @author <a href="mailto:nscavell@redhat.com">Nick Scavelli</a>
 */
public interface DatagramSocketMetrics extends NetMetrics {

  // There should probably be a TcpMetrics that has the connected/disconnected characteristics, but since datagram
  // uses a tcp like connection class internally, it's easier to do it this way

  @Override
  default void connected(SocketAddress remoteAddress) {
    newSocket();
  }

  @Override
  default void disconnected(SocketAddress remoteAddress) {
    close();
  }

  /**
   * Called when a new datagram socket is created.
   */
  void newSocket();
}
