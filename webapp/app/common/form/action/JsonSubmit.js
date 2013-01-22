Ext.define('PHRS.common.form.action.JsonSubmit', {
    extend: 'Ext.form.action.Submit',
    alias: 'formaction.jsonsubmit',

    type: 'jsonsubmit',

    run: function () {
        var encodedParams;

        if (this.getMethod() === 'GET') {
            encodedParams = this.form.getValues();
        } else if (this.jsonRoot) { // POST or PUT  - jsonRoot is optional
            encodedParams = Ext.String.format('{{0}: {1}}', this.jsonRoot.toLowerCase(),
                Ext.encode(this.form.getValues()));
        } else { // POST or PUT
            encodedParams = Ext.String.format('{0}', Ext.encode(this.form.getValues()));
        }

        if (this.clientValidation === false || this.form.isValid()) {
            Ext.Ajax.request(Ext.apply(this.createCallback(), {
                url: this.getUrl(),
                method: this.getMethod(),
                waitMsg: 'Please wait while saving',
                waitTitle: 'Please wait',
                headers: {'Content-Type': 'application/json'},
                params: encodedParams,
                isUpload: this.form.fileUpload
            }));
        } else if (this.clientValidation !== false) { // client validation failed
            this.failureType = Ext.form.Action.CLIENT_INVALID;
            this.form.afterAction(this, false);
        }
    }
});