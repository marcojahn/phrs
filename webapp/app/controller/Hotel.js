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
        console.log('controller hotel launch')
        this.getHotelsStore().load();
        
        this.control({
        	'#hotel-hotelform button[action=saveHotel]': {
        		click: this.saveHotel
        	}
        })
    },

	saveHotel: function() {

        console.log('save Hotel')

        var form = this.getHotelForm();
        
		var hotel = Ext.create('PHRS.model.Hotel', {
			id: null,
			version: null,
			name: form.getForm().findField('name').getValue()
		});
	
		this.getHotelsStore().add(hotel);
	}

});