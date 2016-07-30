<div class="modal fade" id="editModal" tabindex="-1"  role= "dialog"
     aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Close</span>

                </button>
                <h4 class="modal-title" id="editModalLabel">Edit the movie details</h4>
            </div>
            <div class="modal-body">
                <div class="container"/>
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="edit-title" class="col-md-2 control-label">Title:</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="edit-title"placeholder="Title"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-year" class="col-md-2 control-label">Release Year:</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="edit-year" placeholder="Release Year"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-rating" class="col-md-2 control-label">Rated</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="edit-rating" placeholder="MPAA Rating"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-director" class="col-md-2 control-label">Director</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="edit-director" placeholder="Director"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-imdb" class="col-md-2 control-label">IMDB ID</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="edit-imdb"  placeholder="IMDB ID"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-url" class="col-md-2 control-label">Cover Art URL</label>
                        <div class="col-md-6">
                            <textarea class="form-control" id="edit-url" rows= "2" placeholder="Cover Art URL"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-notes" class="col-md-2 control-label">User Notes</label>
                        <div class="col-md-6">
                            <textarea rows="4" class="form-control" id="edit-notes" placeholder="User Notes"></textarea>
                            <input type="hidden" id="edit-id"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-6">
                            <button type="submit" id="edit-button" class="btn btn-default" data-dismiss='modal'>Edit DVD</button>
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