# 코드리뷰 요청 방법
코드를 작성하고 코드리뷰를 요청하는 과정, 즉 PR은 다음의 단계로 수행할 수 있다.
## Step1
* 저장소의 자신의 브랜치를 확인한다.
  * 브랜치가 없다면 생성을 요청한다.
* 자신의 브랜치를 선택하고 프로젝트를 자신의 계정으로 fork한다.
* fork한 저장소를 자신의 컴퓨터로 clone한다.
```bash
git clone -b {본인_아이디} --single-branch https://github.com/{본인_아이디}/{저장소 아이디}
ex) git clone -b iltaek --single-branch https://github.com/iltaek/java-calculator
```
* 기능 구현을 위한 브랜치를 생성한다.
```bash
git branch -b 브랜치이름
ex) git branch -b step1
```
* 통합개발도구(Eclipse 또는 IntelliJ)에 위에서 clone한 프로젝트를 가져온다.(import)
* 기능을 구현한다.
* 기능 구현 후 add, commit
```bash
git status // 변경된 파일 확인
git add -A(또는 .) // 변경된 전체 파일을 한번에 반영
git commit -m "메시지" // 작업한 내용을 메시지에 기록
```
* 본인의 원격저장소에 업로드한다.
```bash
git push origin 브랜치이름
ex) git push origin step1
```
---
## Step2
* github 의 repository에서 브랜치를 작업한 브랜치로 변경한다. (ex. step1)
* 브랜치 오른쪽에 있는 "New pull request" 버튼을 클릭한다.
* 'base fork' 의 브랜치를 자신의 브랜치로 변경한다.
* 현재 작업한 내용을 입력하고 "Create pull request" 버튼을 클릭하여 PR을 보낸다.
* PR을 보낸 후에 리뷰가 완료되어 원격 저장소에 merge 되면 다음 단계를 진행한다.
* 원격 저장소에 현재까지의 자신의 작업이 merge되면 다음의 작업을 수행한다.
---
## Step3
* 원격 저장소에 merge된 브랜치를 삭제한다. (사실, 해도 되고 안해도 된다.) 
```bash
git checkout 본인_아이디
git branch -D 삭제할_브랜치이름
ex) git checkout iltaek
ex) git branch -D step1
```
* merge된 원격 저장소의 자신 브랜치와 로컬 저장소(본인의 컴퓨터)를 동기화하기 위해 remote 저장소를 추가한다.(최초 한번만)
```bash
git remote add {저장소_별칭} base_저장소_url
ex) git remote add upstream https://github.com/iltaek/java-calculator.git
// 위와 같이 통합 저장소를 추가한 후 전체 remote 저장소 목록을 본다.
git remote -v
```
* 통합 저장소에서 자기 브랜치를 가져온다.
```bash
git fetch upstream {본인_아이디}
ex) git fetch upstream iltaek
```
* 통합 저장소와 로컬 저장소(본인의 컴퓨터)를 동기화한다.
```bash
git rebase upstream/본인_아이디
ex) git rebase upstream/iltaek
```
* 다음 단계를 진행하기 위해 새로운 브랜치를 만든다.
```bash
git checkout -b 브랜치이름
ex) git checkout -b step2
```
* 위의 step1~3을 반복한다.
