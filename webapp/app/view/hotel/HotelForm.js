Ext.define('PHRS.view.hotel.HotelForm', {
    extend: 'Ext.form.Panel',

    id: 'hotel-hotelform',
    
    requires: [
        'PHRS.model.Hotel'
    ],
    
    alias: 'widget.hotel-hotelform',
    
    title: 'Neues Hotel',
    
    initComponent: function () {

    	this.items = this.buildItems();
    	
    	this.buttons = this.buildButtons();
    	
    	this.callParent(arguments);
    },
    
	buildItems: function () {
		return [{
    		fieldLabel: 'Name',
    		name: 'name',
    		
    		allowBlank: false,
    		
    		xtype: 'textfield'
    	}];
	},
    
    buildButtons: function () {
    	return [{
    		text: 'Speichern',
    		formBind: true,
    		disabled: true,
    		
    		action: 'saveHotel'
    		
    	}, {
    		text: 'Abbrechen',
    		
    		handler: function () {
    			alert('Abbrechen');
    		}
    	}];
    	
    }

});