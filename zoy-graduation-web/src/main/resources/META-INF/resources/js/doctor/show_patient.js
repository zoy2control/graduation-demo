/**
 * 患者详情页面
 */
(function($, window, ZOY, undefined) {
	'use strict';

	var App = {
		init : function() {
			this.catheElements();
			this.bindEvents();
			this.findDoctorInfo();
			this.renderTable();
		},
		// ·DOM对象
		catheElements : function() {
		    this.$name = $("#name");
            this.$age = $("#age");
		    this.$sex = $("#sex");
		    this.$marriage = $("#marriage");
		    this.$tel = $("#tel");
		    this.$identityNum = $("#identity-num");
		    this.$company = $("#company");
		    this.$addr = $("#addr");
		    this.$tableCaseInfo = $("#table-case-info");
		    this.$btnShowNewCase = $("#btn-new-case");
		},
		// ·绑定事件
		bindEvents : function() {
            this.$btnShowNewCase.on("click", App.showNewCase);
		},
        showNewCase : function () {
		    var _storage = localStorage.getItem("doctor");
		    var _doctor = JSON.parse(_storage);
            var _storage02 = localStorage.getItem("visit_patient");
            var _patient = JSON.parse(_storage02);
            window.location.href = CTX + "/doctor/show/new/case/" + _doctor.doctorId + "/" + _patient.patientId;
        },
        // ·患者过往病史
        renderTable : function() {
			var _table = this.$tableCaseInfo;

			App.$caseInfoDataTable = _table.DataTable(
				{
                    deferLoading: 0,
                    scrollX : true,
                    autoWidth : true,
                    bFilter : false,
                    bLengthChange: false,
                    serverSide : false,
					ajax : function (data, callback, settings) {
						// ·获取数据
                        var _param = App.getCondtion();
						// ·请求ajax
                        $.ajax({
                            url : CTX + "/case/info",
                            type : "POST",
                            dataType : 'json',
                            cache : false,
                            data : _param
                        }).done(function(response, textStatus, jqXHR) {
                            var records = {
                                draw : 2,
                                recordTotal : response.total,
                                recordsFiltered : response.total,
                                data : response.list
                            };
                            callback(records);
                        }).fail(
                            function(jqXHR, textStatus, errorThrown) {
                            });
                    },
                    columns : [
                        {
                            "data" : "",
                            "title":"序号",
                            "render" : function(data, type, row, meta) {
                                return meta.row+1;
                            }
                        }, // 0
                        {
                            "data" : "state",
                            "title":"病况"
                        }, // 1
                        {
                            "data" : "medicineName",
                            "title":"药名"
                        }, // 2
                        {
                            "data" : "medicineNum",
                            "title":"数量"
                        }, // 3
                        {
                            "data" : "doctorName",
                            "title":"医生姓名"
                        }, // 4
                        {
                            "data" : "visitTime",
                            "title":"就诊时间",
                            render : function (data, type, row, meta) {
                                if(data == null){
                                    return "";
                                }else{
                                    return moment(data).format('YYYY-MM-DD');
                                }
                            }
                        }, // 5
                        {
                            "data" : "caseId",
                            "title":"操作",
                            render : function (data, type, row, meta) {
                                var _doctor = localStorage.getItem("doctor");
                                var _parse = JSON.parse(_doctor);
                                return template.render(
                                    "<a href= '" +
                                    "/doctor/case/visit/" +
                                    row.caseId + "/" + _parse.doctorId
                                    +"' target='_blank' title='详情'>详情</a>"
                                )
                            }
                        } //
                    ]
				});
		},
        // ·编辑病况
        editVisit : function () {

        },
        // ·查询患者个人信息
        findDoctorInfo : function () {
          var _param = App.getCondtion();
            $.ajax({
                url : CTX + "/doctor/query/patient",
                type : "POST",
                dataType : 'json',
                cache : false,
                data : _param,
                success: function(data) {
                    // ·查询成功之后，患者个人信息回填 html
                    App.fillDoctorInfo(data);
                },
                error: function(err) {
                    alter(err);
                }
            })
        },
        fillDoctorInfo : function (data) {
            if (null != data) {
                App.$name.val(data.name);
                App.$age.val(data.age);
                App.$sex.val(data.sex);
                if (data.marriage === "0") {
                    App.$marriage.val("未婚");
                } else {
                    App.$marriage.val("已婚");
                }
                App.$tel.val(data.tel);
                App.$identityNum.val(data.identityNum);
                App.$company.val(data.company);
                App.$addr.val(data.addr);
            }
        },
        getCondtion : function () {
            var _param = {};
            var _storage = localStorage.getItem("visit_patient");
            var _parse = JSON.parse(_storage);
            if (_parse.patientId != null) {
                _param.patientId = _parse.patientId;
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