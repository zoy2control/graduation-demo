/**
 * 医生主页面
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
		    this.$formPatientSearch = $("#form-search-patient");
            // ·按钮btn
            this.$btnModifyPass = $("#btn-modify-password");
            this.$btnVisit = $("#btn-visit");
		},
		// ·绑定事件
		bindEvents : function() {
			this.$btnModifyPass.on("click", App.modifyPass);
            this.$btnVisit.on("click", App.visit)
		},
        // ·修改密码
        modifyPass : function () {
            window.location.href = CTX + "/doctor/show/modify/password"
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

            // // 处理 select 表单
            // _$target.find(".s2-rendered").each(function(index, ele) {
            //     var _$ele = $(ele);
            //
            //     var _name = _$ele.attr("name");
            //     var _val = _$ele.select2("val");
            //
            //     data[_name] = _val;
            // });
            //
            // // 处理  radio 表单
            // _$target.find(".radio-rendered").each(function(index, ele) {
            //     var _$ele = $(ele);
            //
            //     if(_$ele.prop("checked") == true) {
            //         var _name = _$ele.prop("name");
            //         var _val = _$ele.val();
            //         data[_name] = _val;
            //     }
            // });
            //
            // // 处理  checkbox 表单
            // _$target.find(".checkbox-rendered").each(function(index, ele) {
            //     var _$ele = $(ele);
            //
            //     if(_$ele.prop("checked") == true) {
            //         var _name = _$ele.prop("name");
            //         var _val = _$ele.val();
            //         data[_name] = _val;
            //     }
            // });
            //
            // // 处理 textarea 表单
            // _$target.find("textarea").each(function(index, ele) {
            //     var _$ele = $(ele);
            //
            //     var _name = _$ele.attr("name");
            //     var _val = _$ele.val();
            //
            //     data[_name] = _val;
            // });
            return data;
        }



	};
    App.init();
})(jQuery, window, ZOY);