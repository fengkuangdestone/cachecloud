<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="addMachineModal${machine.info.id}" class="modal fade" tabindex="-1" data-width="400">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
				<h4 class="modal-title">管理机器</h4>
			</div>
			
			<form class="form-horizontal form-bordered form-row-stripped">
				<div class="modal-body">
					<div class="row">
						<!-- 控件开始 -->
						<div class="col-md-12">
							<!-- form-body开始 -->
							<div class="form-body">
								<div class="form-group">
									<label class="control-label col-md-3">
										机器ip:
									</label>
									<div class="col-md-5">
										<input type="text" name="ip" id="ip${machine.info.id}"
											value="${machine.info.ip}" placeholder="机器ip"
											class="form-control" />
									</div>
								</div>

                                <div class="form-group">
                                    <label class="control-label col-md-3">
                                        机房:
                                    </label>
                                    <div class="col-md-5">
                                        <input type="text" name="room" id="room${machine.info.id}"
                                               value="${machine.info.room}" placeholder="机器所在机房"
                                               class="form-control" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-md-3">
                                        内存（单位G）:
                                    </label>
                                    <div class="col-md-5">
                                        <input type="text" name="mem" id="mem${machine.info.id}"
                                               value="${machine.info.mem}" placeholder="机器内存"
                                               class="form-control" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-md-3">
                                        cpu:
                                    </label>
                                    <div class="col-md-5">
                                        <input type="text" name="cpu" id="cpu${machine.info.id}"
                                               value="${machine.info.cpu}" placeholder="机器CPU核数"
                                               class="form-control" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-md-3">
                                        是否虚机:
                                    </label>
                                    <div class="col-md-5">
                                        <select name="virtual" id="virtual${machine.info.id}" class="form-control select2_category">
                                            <option value="0" <c:if test="${machine.info.virtual == 0}">selected="selected"</c:if>>
                                                否
                                            </option>
                                            <option value="1" <c:if test="${machine.info.virtual == 2}">selected="selected"</c:if>>
                                                是
                                            </option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-md-3">
                                        宿主机ip（虚机需要填写）:
                                    </label>
                                    <div class="col-md-5">
                                        <input type="text" name="realIp" id="realIp${machine.info.id}"
                                               value="${machine.info.realIp}" placeholder="宿主机ip（虚机需要填写）"
                                               class="form-control" />
                                    </div>
                                </div>




								<input type="hidden" id="machineId${machine.info.id}" name="machineId" value="${machine.info.id}"/>
							</div>
							<!-- form-body 结束 -->
						</div>
						<div id="machineInfo${machine.info.id}"></div>
						<!-- 控件结束 -->
					</div>
				</div>
				
				<div class="modal-footer">
					<button type="button" data-dismiss="modal" class="btn" >Close</button>
					<button type="button" id="addMachineBtn${machine.info.id}" class="btn red" onclick="saveOrUpdateMachine('${machine.info.id}')">Ok</button>
				</div>
			
			</form>
		</div>
	</div>
</div>
