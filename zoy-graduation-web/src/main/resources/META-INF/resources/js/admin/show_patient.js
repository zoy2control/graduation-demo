/**
 * 患者查询
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
		    // ·页面标签
		    this.$patientId = $("#patient-id");
            // ·按钮btn
            this.$btnVisit = $("#btn-visit");
		},
		// ·绑定事件
		bindEvents : function() {
            this.$btnVisit.on("click", App.visit)
		},
        visit : function() {
            this.$patientId = App.getFormData($("#form-search-patient")[0]);
		    localStorage.setItem("visit_patient", JSON.stringify(this.$patientId));
		    window.location.href = CTX + "/doctor/show/patient"
        },
        getFormData: function(target) {
            var _$target = target;
            var data = {};

            // 处理 input 表单
            $(_$target).find("input").each(function(index, ele) {
                var _$ele = $(ele);

                var _name = _$ele.prop("name");
                var _val = _$ele.val();

                data[_name] = _val;
            });
            return data;
        }



	};
    App.init();
})(jQuery, window, ZOY);