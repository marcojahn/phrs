Ext.define('PHRS.store.Hotels', {
    extend: 'Ext.data.Store',

    model: 'PHRS.model.Hotel',

    storeId: 'Hotels',

    proxy: {
        type: 'rest',
        url: 'http://localhost:8080/phrs/rest/hotel/v1',
        /*actionMethods: {
            create: 'POST',
            read: 'GET',
            update: 'PUT',
            destroy: 'DELETE'
        }/*,
        afterRequest: function (request, success) {
            console.log('afterrequest: ' + success);
        },*/
        /*listeners: {
            exception: function (proxy, response, options) {

            }
        }*/
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
            msg: 'Error while changing server data on /hotel/v1',
            buttons: Ext.Msg.OK,
            icon: Ext.Msg.ERROR
        });

        console.log(proxy, response, options);
    },

    createRecordEmpty: function () {
        return Ext.create('PHRS.model.Hotel');
    }
});