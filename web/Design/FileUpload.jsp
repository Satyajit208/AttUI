<!--<script src="./js/r.js"></script>-->

<style>
  .modal-header, h5, .close {
      background-color: black;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-footer {
      background-color: #f9f9f9;
  }
  </style>
  <div class="container">
  
  <!-- Modal -->
  <div class="modal fade" id="fileModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Choose File To Upload</h4>
        </div>
        <div class="modal-body">
            <form method="post" action="FileUploadServlet" enctype="multipart/form-data">
           
            <input type="file" name="uploadFile" />
            <br/>
            <input type="submit" class="btn btn-group-vertical   btn-primary " value="Upload" />
        </form>
        </div>
       </div>
      
    </div>
  </div>
  
</div>
<!--  <script type="text/javascript">
      function myFunction()
      {
      var x=document.getElementById("filebtn").value;
      
     console.log(x);
       //var fs = require('fs');
            var fs =require('fs-extra');
            fs.createReadStream('x').pipe(fs.createWriteStream('newx.txt'));
            //fs.readFileSyc
            alert(x);
        }</script>-->