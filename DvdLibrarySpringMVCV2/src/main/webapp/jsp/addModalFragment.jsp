<div class="modal fade" id="addModal" tabindex="-1"  role= "dialog"
     aria-labelledby="addModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4>Add a DVD by searching IMDB or filling out fields manually</h4>
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Close</span>

                </button>
               
            </div>
            <div class="modal-body">
                <div class="container col-md-4">
                    <input type="text" id="search"/><br>
                    <button class="btn btn-default" onclick="render()">Search</button>
                    <div id="searchResults"></div>
                </div>
                <div class="container col-md-8">
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="title" class="col-md-4 control-label">Title:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="title"placeholder="Title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="year" class="col-md-4 control-label">Release Year:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="year" placeholder="Release Year"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="Rating" class="col-md-4 control-label">Rated</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="Rating" placeholder="MPAA Rating"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="addDirector" class="col-md-4 control-label">Director</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="addDirector" placeholder="Director"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="addIMDB" class="col-md-4 control-label">IMDB ID</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="addIMDB"  placeholder="IMDB ID"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="addURL" class="col-md-4 control-label">Cover Art URL</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="addURL"  placeholder="Cover Art URL"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="addNotes" class="col-md-4 control-label">User Notes</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="addNotes" placeholder="User Notes"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="add-button" class="btn btn-default" data-dismiss='modal'>Add DVD</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="container"></div>
            </div>

            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
