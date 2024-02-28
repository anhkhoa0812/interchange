function addNewRecord() {
    var tbody = document.querySelector("#manage-product-table-1 tbody");

  // Create a new row and cells
  var row = document.createElement("tr");
  row.className = "display-input-none-border";
  for (var i = 0; i < 10; i++) {
    var cell = document.createElement("td");
    var input = document.createTextNode("");
    
    cell.appendChild(input);
    row.appendChild(cell);
  }
    var cell = document.createElement("td");
    var input = document.createElement("button");
    input.className = "delete-icon";
    input.innerHTML='<i style="font-size:12px" class="fa">&#xf00d;</i>';
    cell.appendChild(input);
    row.appendChild(cell);

  // Append the new row to the tbody
  tbody.appendChild(row);
}

function addNewTable() {
    
        var newTable = document.createElement('table');
        newTable.className = ".content-table .show-product";
        newTable.innerHTML = `
        <thead>
        <tr>
            <th class="display-column" rowspan="2">Sản phẩm</th>
            <th class="display-column" rowspan="2">Mô tả</th>
            <th class="display-column" colspan="3">Kích thước</th>
            <th class="display-column" rowspan="2">Đơn vị</th>
            <th class="display-column" rowspan="2">Số lượng</th>
            <th class="display-column" rowspan="2">Đơn giá</th>
            <th rowspan="2">Hình tham khảo</th>
            <th class="display-column" rowspan="2">Thành tiền</th>
            <th rowspan="2"></th>
        </tr>
        <tr>
            <th>Dài</th>
            <th>Rộng</th>
            <th>Cao</th>
        </tr>
    </thead>
            <tbody>
            
            </tbody>
            <tfoot>
            <tr>
            <td colspan="9">Tổng</td>
            <td class="text-aligh-center" colspan="1">15.000.000 đồng</td>
        </tr>
            </tfoot>
        `;
        document.getElementById('manage-product-div').appendChild(newTable);
    
  }

  function DeleteChosednRow() {
    $(document).ready(function(){
        $('table#manage-product-table-1 tbody').on('click', 'button', function(){
            $(this).closest('tr').remove();
        });
    });
  }