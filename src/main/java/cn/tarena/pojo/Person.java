package cn.tarena.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="person_info")
public class Person {
	@Id
	String id;
	String nickName;//昵称
	String age;//年龄
	String height;//身高
	String education;//学历
	String addr;//住址
	String marry;//婚否
	String descrip;//自我介绍	
	String image; //照片
	
	String account;//户口
	String nation;//民族
	String hometown;//家乡
	String animal;//属相
	String constellation;	//	星座
	String blood;	//	血型
	String size; //	体型
	String weight;	//	体重
	String occupation;	//	职业
	String salary;	//	月薪
	String house;	//	购房
	String car;	//	购车
	String language;	//	掌握语言
	String school;	//	毕业学校
	String profession;//	所学专业
	String religion;	//	宗教信仰
	String lifestyle;	//	生活作息
	String child;	//	有无子女
	String looks;	//	相貌自评
	String smoking;	//	是否吸烟
	String drink;	//	是否喝酒
	String companyType;	//	公司性质
	String companyIndustry;	//	公司行业
	String workingCondition;	//	工作状况
	String rank;	//	家中排行
	String psituation;	//	父母情况
	String faWork;	//	父亲工作
	String maWork;	//	母亲工作
	String peconomic;	//	父母经济
	String pmedicare;	//	父母医保
	String plive;	//	愿与长辈同住
	String mtime;	//	想何时结婚
	String getChildren;	//	是否想要小孩
	String mode;	//	偏爱约会方式
	String important;	//	希望对方看中
	String marryStyle;	//	期待婚礼形式
	String cook;	//	厨艺状况
	String division;	//	家务分工	
	String hisAge;	//	年　龄：
	String hisHeight;	//	身　高：
	String hisEducation;	//	学　历：
	String hisSalary;	//	月收入：
	String hisAddr;	//	所在地区：
	String hisMarry;	//	婚姻状况：
	String hisHouse;	//	购房情况：
	String hisChildren;	//	有无子女：
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getMarry() {
		return marry;
	}
	public void setMarry(String marry) {
		this.marry = marry;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public String getConstellation() {
		return constellation;
	}
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getLifestyle() {
		return lifestyle;
	}
	public void setLifestyle(String lifestyle) {
		this.lifestyle = lifestyle;
	}
	public String getChild() {
		return child;
	}
	public void setChild(String child) {
		this.child = child;
	}
	public String getLooks() {
		return looks;
	}
	public void setLooks(String looks) {
		this.looks = looks;
	}
	public String getSmoking() {
		return smoking;
	}
	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getCompanyIndustry() {
		return companyIndustry;
	}
	public void setCompanyIndustry(String companyIndustry) {
		this.companyIndustry = companyIndustry;
	}
	public String getWorkingCondition() {
		return workingCondition;
	}
	public void setWorkingCondition(String workingCondition) {
		this.workingCondition = workingCondition;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public String getFaWork() {
		return faWork;
	}
	public void setFaWork(String faWork) {
		this.faWork = faWork;
	}
	public String getMaWork() {
		return maWork;
	}
	public void setMaWork(String maWork) {
		this.maWork = maWork;
	}
	
	public String getGetChildren() {
		return getChildren;
	}
	public void setGetChildren(String getChildren) {
		this.getChildren = getChildren;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getImportant() {
		return important;
	}
	public void setImportant(String important) {
		this.important = important;
	}
	public String getMarryStyle() {
		return marryStyle;
	}
	public void setMarryStyle(String marryStyle) {
		this.marryStyle = marryStyle;
	}
	public String getCook() {
		return cook;
	}
	public void setCook(String cook) {
		this.cook = cook;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getHisAge() {
		return hisAge;
	}
	public void setHisAge(String hisAge) {
		this.hisAge = hisAge;
	}
	public String getHisHeight() {
		return hisHeight;
	}
	public void setHisHeight(String hisHeight) {
		this.hisHeight = hisHeight;
	}
	public String getHisEducation() {
		return hisEducation;
	}
	public void setHisEducation(String hisEducation) {
		this.hisEducation = hisEducation;
	}
	public String getHisSalary() {
		return hisSalary;
	}
	public void setHisSalary(String hisSalary) {
		this.hisSalary = hisSalary;
	}
	public String getHisAddr() {
		return hisAddr;
	}
	public void setHisAddr(String hisAddr) {
		this.hisAddr = hisAddr;
	}
	public String getHisMarry() {
		return hisMarry;
	}
	public void setHisMarry(String hisMarry) {
		this.hisMarry = hisMarry;
	}
	public String getHisHouse() {
		return hisHouse;
	}
	public void setHisHouse(String hisHouse) {
		this.hisHouse = hisHouse;
	}
	public String getHisChildren() {
		return hisChildren;
	}
	public void setHisChildren(String hisChildren) {
		this.hisChildren = hisChildren;
	}
	public String getPsituation() {
		return psituation;
	}
	public void setPsituation(String psituation) {
		this.psituation = psituation;
	}
	public String getPeconomic() {
		return peconomic;
	}
	public void setPeconomic(String peconomic) {
		this.peconomic = peconomic;
	}
	public String getPmedicare() {
		return pmedicare;
	}
	public void setPmedicare(String pmedicare) {
		this.pmedicare = pmedicare;
	}
	public String getPlive() {
		return plive;
	}
	public void setPlive(String plive) {
		this.plive = plive;
	}
	public String getMtime() {
		return mtime;
	}
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", nickName=" + nickName + ", age=" + age + ", height=" + height + ", education="
				+ education + ", addr=" + addr + ", marry=" + marry + ", descrip=" + descrip + ", account=" + account
				+ ", nation=" + nation + ", hometown=" + hometown + ", animal=" + animal + ", constellation="
				+ constellation + ", blood=" + blood + ", size=" + size + ", weight=" + weight + ", occupation="
				+ occupation + ", salary=" + salary + ", house=" + house + ", car=" + car + ", language=" + language
				+ ", school=" + school + ", profession=" + profession + ", religion=" + religion + ", lifestyle="
				+ lifestyle + ", child=" + child + ", looks=" + looks + ", smoking=" + smoking + ", drink=" + drink
				+ ", companyType=" + companyType + ", companyIndustry=" + companyIndustry + ", workingCondition="
				+ workingCondition + ", rank=" + rank + ", psituation=" + psituation + ", faWork=" + faWork
				+ ", maWork=" + maWork + ", peconomic=" + peconomic + ", pmedicare=" + pmedicare + ", plive=" + plive
				+ ", mtime=" + mtime + ", getChildren=" + getChildren + ", mode=" + mode + ", important=" + important
				+ ", marryStyle=" + marryStyle + ", cook=" + cook + ", division=" + division + ", hisAge=" + hisAge
				+ ", hisHeight=" + hisHeight + ", hisEducation=" + hisEducation + ", hisSalary=" + hisSalary
				+ ", hisAddr=" + hisAddr + ", hisMarry=" + hisMarry + ", hisHouse=" + hisHouse + ", hisChildren="
				+ hisChildren + "]";
	}
	
	
	
	
	
	
}	
