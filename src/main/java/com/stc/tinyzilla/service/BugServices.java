/**
 * 
 */
package com.stc.tinyzilla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.stc.tinyzilla.tinyzilla.model.Bug;
import com.stc.tinyzilla.tinyzilla.service.data.DataLayerTinyzilla;

/**
 * @author wwadge
 *
 */
@Component
public class BugServices {

	@Autowired
	DataLayerTinyzilla dataLayer;
	
	@Transactional
	public void createBug(String title){
		Bug bug = new Bug();
		bug.setTitle(title);
		dataLayer.save(bug);
	}
}
