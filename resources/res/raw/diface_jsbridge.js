(function () {
   if (window.DiGuardianJSBridge) {
       console.log("DiGuardianJSBridge already exist!!!");
       return 110;
   }
   console.log("DiGuardianJSBridge init begin====");
   var win = window;
   var callbacks = {};

   function invoke(command, params, callback) {
       var paramsStr = JSON.stringify(params);
       callbacks[command] = callback;
       NativeHandler.invoke(command, paramsStr, '_diface_callback_handler');
   }

   function _notifyCallback(command, jsonResp) {
       var json = JSON.parse(jsonResp);
       var callback = callbacks[command];
       delete callbacks[command];
       var errCode = 0;
       if (callback) {
           callback(json);
       } else {
           errCode = -1;
       }
       return errCode;
   }

   win._diface_callback_handler = _notifyCallback;

   win.DiGuardianJSBridge = {
       invoke: invoke,
   };
   console.log("DiGuardianJSBridge init end====")
   return 111;
})();
