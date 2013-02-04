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
            '#hotel-hotelform button[action=resetHotel]': {
                click: this.resetHotel
            }
        });

        this.initForm();

    },

    initForm: function () {
        var record = this.getHotelsStore().createRecordEmpty();

        /* dev, remove later */
        record = this.devPrepare();
        /* // dev */

        this.getHotelForm().getForm().loadRecord(record);
    },

	saveHotel: function() {
        var record = this.getHotelForm().getForm().getRecord();
        this.getHotelForm().getForm().updateRecord(record);
        this.getHotelsStore().add(record);
	},

    resetHotel: function () {
        this.getHotelForm().getForm().reset();

        /* dev, remove later */
        var record = this.devPrepare();
        this.getHotelForm().getForm().loadRecord(record);
        /* // dev */
    },

    devPrepare: function () {
        function getRandomInt (min, max) {
            return Math.floor(Math.random() * (max - min + 1)) + min;
        }
        return Ext.create('PHRS.model.Hotel', {
            name: 'Testhotel ' + getRandomInt(1, 100),
            street: 'Straße ' + getRandomInt(1, 100),
            streetNumber:  + getRandomInt(1, 100),
            city: 'Musterstadt ' + getRandomInt(1, 100),
            zipCode: 1234 + '' + getRandomInt(1, 100),
            country: 'Deutschland',
            phoneNumber: '+49-123-45678-' + getRandomInt(1, 100),
            faxNumber: '+49-123-45678-' + getRandomInt(1, 100),
            email: 'max@muster.de'
        });
    }

});