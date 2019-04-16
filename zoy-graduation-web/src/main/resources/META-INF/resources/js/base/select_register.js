/**
 * 主注册页面
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
			this.$btnDoctor = $("#btn-doctor-reg");
            this.$btnPatient = $("#btn-patient-reg");
		},
		// ·绑定事件
		bindEvents : function() {
			this.$btnDoctor.on("click", App.registerDoctor);
            this.$btnPatient.on("click", App.registerPatient);
		},
        // ·医生注册
        registerDoctor : function () {
            window.location.href=CTX + '/doctor/show/register';
        },
        // ·患者注册
        registerPatient : function () {
			window.location.href=CTX + '/patient/show/register';
        }
	};
    App.init();
})(jQuery, window, ZOY);