Ext.define('PHRS.controller.Reservation', {
    extend: 'Ext.app.Controller',

    refs: [{
    	ref: 'saveReservationButton',
    	selector: '#reservation-reservationform [button=saveReservation]'
    }, {
    	ref: 'reservationForm',
    	selector: '#reservation-reservationform'
    }],
    
    models: ['Reservation'],
    stores: ['Reservations'],

    onLaunch: function () {
        this.getReservationsStore().load();
        
        this.control({
        	'#reservation-reservationform button[action=saveReservation]': {
        		click: this.saveReservation
        	}
        });

        this.initForm();

    },

    initForm: function () {
        var record = this.getReservationsStore().createRecordEmpty();

        // dev, remove later
        record = Ext.create('PHRS.model.Reservation');
        record.status = 'CREATED';

        this.getReservationForm().getForm().loadRecord(record);
    },

	saveReservation: function() {
        var record = this.getReservationForm().getForm().getRecord();
        this.getReservationForm().getForm().updateRecord(record);

        var submitValue = this.getReservationForm().getForm().findField('hotel').getSubmitValue();
        console.log('selected hotel id: ' + submitValue);

        // TODO quick hack
        var hotelRecord = Ext.StoreManager.get('Hotels').getById(submitValue);

        record.setHotel(hotelRecord);

        this.getReservationsStore().add(record);
	}

});