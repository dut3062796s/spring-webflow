/*
 * Copyright 2010-2012 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.faces.support;

import java.io.IOException;

import javax.faces.FacesWrapper;
import javax.faces.application.StateManager.SerializedView;
import javax.faces.context.FacesContext;
import javax.faces.render.ResponseStateManager;

/**
 * Provides a simple implementation of {@link ResponseStateManager} that can be subclassed by developers wishing to
 * provide specialized behavior to an existing {@link ResponseStateManager instance} . The default implementation of all
 * methods is to call through to the wrapped {@link ResponseStateManager}.
 * 
 * @author Phillip Webb
 * 
 * @since 2.4
 */
@SuppressWarnings("deprecation")
public abstract class ResponseStateManagerWrapper extends ResponseStateManager implements
		FacesWrapper<ResponseStateManager> {

	public abstract ResponseStateManager getWrapped();

	@Override
	public void writeState(FacesContext context, Object state) throws IOException {
		getWrapped().writeState(context, state);
	}

	@Override
	@Deprecated
	public void writeState(FacesContext context, SerializedView state) throws IOException {
		getWrapped().writeState(context, state);
	}

	@Override
	public Object getState(FacesContext context, String viewId) {
		return getWrapped().getState(context, viewId);
	}

	@Override
	@Deprecated
	public Object getTreeStructureToRestore(FacesContext context, String viewId) {
		return getWrapped().getTreeStructureToRestore(context, viewId);
	}

	@Override
	@Deprecated
	public Object getComponentStateToRestore(FacesContext context) {
		return getWrapped().getComponentStateToRestore(context);
	}

	@Override
	public boolean isPostback(FacesContext context) {
		return getWrapped().isPostback(context);
	}

	@Override
	public String getViewState(FacesContext context, Object state) {
		return getWrapped().getViewState(context, state);
	}
}
