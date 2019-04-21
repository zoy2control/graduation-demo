/**
 * 患者病例页面
 */
(function($, window, ZOY, undefined) {
	'use strict';

	var App = {
		init : function() {
			this.catheElements();
			this.bindEvents();
			this.findPatientInfo();
		},
		// ·DOM对象
		catheElements : function() {
		    this.$name = $("#name");
            this.$age = $("#age");
		    this.$state = $("#state");
		    this.$medName = $("#medicine-name");
		    this.$medNum = $("#medicine-num");
		    this.$formCaseInfo = $("#case-info");
		    this.$btnCommit = $("#btn-commit");
		},
		// ·绑定事件
		bindEvents : function() {
            this.$btnCommit.on("click", App.commit);
		},
        commit : function () {
            var _formData = App.getFormData($("#case-info")[0]);
            $.ajax({
                url : CTX + "/doctor/case/save",
                type : "POST",
                dataType : 'json',
                cache : false,
                data : _formData,
                success: function(data) {
                    // ·提交就诊记录成功后，跳转到患者详情页面
                    window.location.href = CTX + "/doctor/show/patient"
                },
                error: function(err) {
                    window.location.href = CTX + "/doctor/show/patient"
                }
            })
        },
        // ·查询患者个人信息
        findPatientInfo : function () {
          var _param = App.getPatientInfo();
            $.ajax({
                url : CTX + "/doctor/query/patient",
                type : "POST",
                dataType : 'json',
                cache : false,
                data : _param,
                success: function(data) {
                    // ·查询成功之后，患者个人信息回填 html
                    App.fillPatientInfo(data);
                },
                error: function(err) {
                    alter(err);
                }
            })
        },
        fillPatientInfo : function (data) {
            if (null != data) {
                App.$name.val(data.name);
                App.$age.val(data.age);
            }
        },
        getPatientInfo : function () {
            var _param = {};
            var _storage = localStorage.getItem("visit_patient");
            var _parse = JSON.parse(_storage);
            if (_parse.patientId != null) {
                _param.patientId = _parse.patientId;
            }
            return _param;
        },
        getDocterInfo : function () {
            var _param = {};
            var _storage = localStorage.getItem("visit_patient");
            var _parse = JSON.parse(_storage);
            var _docter = localStorage.getItem("doctor");
            var _parseDoctor = JSON.parse(_docter);
            if (_parse.patientId != null) {
                _param.patientId = _parse.patientId;
            }
            if(_parseDoctor.docterId != null) {
                _param.docterId = _parseDoctor.docterId;
            }
            return _param;
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