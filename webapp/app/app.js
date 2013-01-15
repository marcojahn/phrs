Ext.onReady(function () {
    Ext.Ajax.defaultHeaders = {
        'Content-Type': 'application/json; charset=UTF-8'
    };

    Ext.application({
        name: 'PHRS',
        autoCreateViewport: true,

        //controllers: ['PHRS.controller.XY'],

        launch: function () {
            console.log('application launch')
        }
    });
}());