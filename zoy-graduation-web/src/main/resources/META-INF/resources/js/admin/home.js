/**
 * 管理员主页面
 */
(function($, window, ZOY, undefined) {
	'use strict';

	var App = {
		init : function() {
			this.catheElements();
			this.bindEvents();
		},
		// ·DOM对象
		catheElements : function() {
            // ·按钮btn
            this.$btnPatientMgr = $("#btn-patient-mgr");
            this.$btnDoctorMgr = $("#btn-doctor-mgr");
		},
		// ·绑定事件
		bindEvents : function() {
			this.$btnPatientMgr.on("click", App.showPatient);
            this.$btnDoctorMgr.on("click", App.showDoctor);
		},
		showPatient : function () {
            window.location.href = CTX + "/admin/show/patient"
        },
        showDoctor : function () {
		    window.location.href = CTX + "/admin/show/doctor"
        }
	};
    App.init();
})(jQuery, window, ZOY);