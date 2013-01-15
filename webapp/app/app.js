(function () {
    Ext.Ajax.defaultHeaders = {
        'Content-Type': 'application/json; charset=UTF-8'
    };

    Ext.application({
        name: 'PHRS',
        autoCreateViewport: false,
        requires: ['PHRS.view.Viewport'],

        //controllers: ['PHRS.controller.XY'],

        launch: function () {
            console.log('running login');
            //this.login();
        }
    });
})();