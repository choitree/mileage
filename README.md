# 트리플여행자 클럽 마일리지 서비스

## 요구사항 
### 리뷰 작성을 할 경우, 리뷰 작성 이벤트가 POST / events 로 이루어지고, 리뷰가 저장된다.

```
{
"type": "REVIEW",
"action": "ADD", /* "MOD", "DELETE" */
"reviewId": "240a0658-dc5f-4878-9381-ebb7b2667772",
"content": "좋아요!",
"attachedPhotoIds": ["e4d1a64e-a531-46de-88d0-ff0ed70c0bb8", "afb0cef2-
851d-4a50-bb07-9cc15cbdc332"],
"userId": "3ede0ef2-92b7-4817-a5f3-0c575361f745",
"placeId": "2e4baf1c-5acb-4efb-a1af-eddada31b00f"
}
```
* type: 미리 정의된 string 타입으로, 리뷰 이벤트의 경우 "REVIEW"입니다. 확장성을 위해서 enum을 만들어서 사용했습니다.
* action: 리뷰 생성 이벤트의 경우 "ADD" , 수정 이벤트는 "MOD" , 삭제 이벤트는 "DELETE" 값을 가지고 있습니다.
* reviewId: UUID 포맷의 review id입니다. 어떤 리뷰에 대한 이벤트인지 가리키는 값입니다.
* content: 리뷰의 내용입니다.
* attachedPhotoIds: 리뷰에 첨부된 이미지들의 id 배열입니다. 포맷이 명시되있지는 않지만, UUID 타입으로 지정했습니다.
* userId: 리뷰의 작성자 id입니다. 포맷이 명시되있지는 않지만, UUID 타입으로 지정했습니다.
* placeId: 리뷰가 작성된 장소의 id입니다. 포맷이 명시되있지는 않지만, UUID 타입으로 지정했습니다.

---

