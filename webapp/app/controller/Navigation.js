Ext.define('PHRS.controller.Navigation', {
    extend: 'Ext.app.Controller',

    models: ['Navigation'],
    stores: ['Navigations'],

    onLaunch: function () {
        console.log('controller navigation launch')
        this.getNavigationsStore().load();
    }
});