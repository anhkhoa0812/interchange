var input = document.querySelector(".input-box");
        input.onclick = function () {
            this.classList.toggle("open");
            let list = this.nextElementSibling;
            if (list.style.maxHeight) {
                list.style.maxHeight = null;
                list.style.boxShadow = null;
            } else {
                list.style.maxHeight = list.scrollHeight + "px";
                list.style.boxShadow =
                    "0 1px 2px 0 rgba(0, 0, 0, 0.15),0 1px 3px 1px rgba(0, 0, 0, 0.1)";
            }
        };

        var rad = document.querySelectorAll(".radio");
        rad.forEach((item) => {
            item.addEventListener("change", () => {
                input.innerHTML = item.nextElementSibling.innerHTML;
                input.click();
            });
        });

        var label = document.querySelectorAll("label");
        function search(searchin) {
            let searchVal = searchin.value;
            searchVal = searchVal.toUpperCase();
            label.forEach((item) => {
                let checkVal = item.querySelector(".name").innerHTML;
                checkVal = checkVal.toUpperCase();
                if (checkVal.indexOf(searchVal) == -1) {
                    item.style.display = "none";
                } else {
                    item.style.display = "flex";
                }
                let list = input.nextElementSibling;
                list.style.maxHeight = list.scrollHeight + "px";
            });
        }