Ext.define('PHRS.store.Reservations', {
    extend: 'Ext.data.Store',

    model: 'PHRS.model.Reservation',
    
    storeId: 'Reservations',

    proxy: {
        type: 'rest',
        url: 'http://localhost:8080/phrs/rest/reservation/v1',
        writer: {
            type: 'json2'
        }
    },

    autoSync: true,
    
    // replace with generic error handling
    constructor: function () {
        this.callParent(arguments);
        this.proxy.on('exception', this.onProxyException, this);
    },

    onProxyException: function (proxy, response, options) {
        this.rejectChanges();

        Ext.Msg.show({
            title: 'Error',
            msg: 'Error while changing server data on /reservation/v1',
            buttons: Ext.Msg.OK,
            icon: Ext.Msg.ERROR
        });

        console.log(proxy, response, options);
    },

    createRecordEmpty: function () {
        return Ext.create('PHRS.model.Reservation');
    }
});