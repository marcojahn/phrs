Ext.define('PHRS.controller.Hotel', {
    extend: 'Ext.app.Controller',

    models: ['Hotel'],
    stores: ['Hotels'],

    onLaunch: function () {
        console.log('controller hotel launch')
        this.getHotelsStore().load();
    }
});