document.addEventListener("DOMContentLoaded", () => {
  // alert("안녕");
  const input_b_name = document.querySelector("input#b_name");
  const input_b_code = document.querySelector("input#rent_bcode");
  const input_b_comp = document.querySelector("input#b_comp");
  const result_list = document.querySelector("div.search.list");

  const result_listClickHandler = (e) => {
    const book_item = e.target;
    if (book_item.tagName !== "DIV") {
      return false;
    }
    input_b_code.value = book_item.dataset.bcode;
    input_b_comp.value = book_item.dataset.bcomp;
    input_b_name.value = book_item.dataset.bname;
    result_list.style.display = "none";
  };
  result_list?.addEventListener("click", result_listClickHandler);

  const bnameSearch = async (e) => {
    const bname = e.target.value;
    if (bname.length < 2) {
      // 두글자 이하면 반응 x
      result_list.style.display = "none";
      return false;
    }
    result_list.style.display = "block";
    // ?변수=값 으로보내는 데이터 : queryString 방식의 요청
    const url = `${rootPath}/book/name/search?b_name=${bname}`;
    const response = await fetch(url);
    const result = await response.json();
    // console.log(result);
    // 결과 리스트 clear
    result_list.innerHTML = "";
    // result 배열(List) 전체를 반복 순회 하면서
    // 각각의 요소를 book 에 담아 내부의 함수로 전달하라
    result.forEach((book) => {
      console.table(book);

      // div tag 를 새로 생성하기
      const book_item = document.createElement("div");

      // 새로 생성된 div 의 innerHTML 속성을 통하여 문자열 보이기

      const text = `${book.b_name} : ${book.b_comp} : ${book.b_auther}`;

      book_item.innerHTML = text.replaceAll(
        `${bname}`,
        `<span class="search-item">${bname}</span>`
      );
      // 도서코드, 도서명, 출판사를 div 의 dataset으로 채워넣기
      book_item.dataset.bcode = book.b_code;
      book_item.dataset.bcomp = book.b_comp;
      book_item.dataset.bname = book.b_name;

      // result_list 의 child 로 추가하기
      result_list.appendChild(book_item);
    });
  };
  input_b_name?.addEventListener(
    "keyup",
    debounce((e) => {
      bnameSearch(e);
    })
  );

  /*
    키보드 관련 event
    keydown : 키가 눌리는 순간
              Enter, Esc 등 특수키 값을 Capture 할 수 있다
    keypress : keydown 거의 유사
    keyup : 키보드에서 손이 떼어지는 순간
              숫자, 영문자
  */
});
