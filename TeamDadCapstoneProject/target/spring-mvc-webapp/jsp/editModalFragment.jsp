<div class="modal" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog ui-corner-all">
        <div class="modal-content">
            <div class="modal-body">

                <div id="editModalBody">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="teamTitle" class="col-sm-2 control-label">Title:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control"  data-toggle="tooltip" data-placement="bottom"  title="Static pages require a title!" id="teamTitle" placeholder="Title Required For Static Pages">
                            </div>
                        </div>
                    </form>
                        <div id="editSummerNote"></div>

                        <div class="row" id="datesRow">

                            <div class="col-xs-6">Go Live date<input id="goLive" type="text" placeholder=" Publish Instantly"></div>
                            <div class="col-xs-6">Expiration Date<input id="expire" type="text" placeholder=" Never Expire"></div>
                        </div>
                        <div class="row">
                            <div class="col-xs-1">Status:</div>
                            <div class="col-xs-5">
                                <select class="form-control" id="statusMenu" name="status">
                                    <option>Post</option>
                                    <option>Pending</option>
                                    <option>Static</option>
                                </select>
                            </div>
                            <div class="col-xs-6"><button id="saveEdit" class="btn btn-primary">Save</button></div>
                        </div>
                </div>
            </div>
        </div>
    </div>
</div>
