/*******************************************************************************
 * Copyright (c) 2018 Bosch Software Innovations GmbH
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

 package org.eclipse.iot.unide.integrators;

import org.apache.camel.spring.Main;

public class IntegratorMain {
	private static final Main main = new Main();

    public static void main(String[] args) throws Exception {
		if(args.length > 0 && "stop".equals(args[0]) && main.isStarted()) {
			main.stop();
		} else if(!main.isStarted()) {
			main.setApplicationContextUri("classpath:application-context.xml");
			// main.enableHangupSupport();
			main.run();
		}
    }
}
