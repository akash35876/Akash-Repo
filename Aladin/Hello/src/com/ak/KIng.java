package com.ak;

public class KIng {

	public static void main(String[] args) {
		 
		Heelo h = new Heelo();		
		h.setAge("Akash");
		h.setMonth("November");
		h.setName("AKSh");
		h.setSno("1");
		 System.out.println(h.toStringValues());
	}
	
	static class Heelo{
		private String sno;
		private String name;
		private String age;
		private String month;
		public Heelo(String string, String string2, String string3, String string4) {
			 
		}
		public Heelo() {
			// TODO Auto-generated constructor stub
		}
		public String getSno() {
			return sno;
		}
		public void setSno(String sno) {
			this.sno = sno;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getMonth() {
			return month;
		}
		public void setMonth(String month) {
			this.month = month;
		}
		 public String toStringValues() {
	            return "sno='" + sno + '\'' +
	                    ", name='" + name + '\'' +
	                    ", age='" + age + '\'' +
	                    ", month='" + month + '\'';
	        }
	}

}
