Ext.define('PHRS.controller.Hotel', {
    extend: 'Ext.app.Controller',

    refs: [{
    	ref: 'saveHotelButton',
    	selector: '#hotel-hotelform [button=saveHotel]'
    }, {
    	ref: 'hotelForm',
    	selector: '#hotel-hotelform'
    }],
    
    models: ['Hotel'],
    stores: ['Hotels'],

    onLaunch: function () {
        this.getHotelsStore().load();
        
        this.control({
        	'#hotel-hotelform button[action=saveHotel]': {
        		click: this.saveHotel
        	},
            '#hotel-hotelform button[aciton=resetHotel]': {
                click: this.resetHotel
            }
        });

        this.resetHotel();

    },

	saveHotel: function() {
        var record = this.getHotelForm().getForm().getRecord();
        this.getHotelForm().getForm().updateRecord(record);
        this.getHotelsStore().add(record);
	},

    resetHotel: function () {
        var record = this.getHotelsStore().createRecordEmpty();
        this.getHotelForm().getForm().loadRecord(record);
    }

});