
/*��׮��¼*/

CREATE TABLE record (
  record_no INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '���',
  machine_no VARCHAR(255) NOT NULL COMMENT '׮�����',
  pile_no VARCHAR(255) DEFAULT NULL COMMENT '׮����',
  first_weight INT(10) DEFAULT NULL COMMENT '��һ����������,��ȷ��ǧ��',
  second_weight INT(10) DEFAULT NULL COMMENT '�ڶ�����������,��ȷ��ǧ��',
  first_depth FLOAT(10) DEFAULT NULL COMMENT '��һ��������ȣ���ȷ����',
  second_depth FLOAT(10) DEFAULT NULL COMMENT '�ڶ���������ȣ���ȷ����',
  sum_depth FLOAT(10) DEFAULT NULL COMMENT '����ȣ���ȷ����',
  collect_data VARCHAR(255) DEFAULT NULL COMMENT 'ʵ�ʲɼ�����,�������ϱ������ݣ�Ҳ���ǽ���֮ǰ������,#�ŷָ�',
  weight_record text DEFAULT NULL '��25�У���ȷ����',
  gather_time DATETIME DEFAULT NULL COMMENT '�������ʱ��ʱ��',
  begin_time DATETIME DEFAULT NULL COMMENT '��ʼʱ��',
  end_time DATETIME DEFAULT NULL COMMENT '����ʱ��',
  isdeleted int default 0 COMMENT '0��ʾû��δɾ����1��ʾ��ɾ��',
  var1 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�1',
  var2 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�2',
  var3 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�3',
  var4 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�4',
  var5 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�5'
) ENGINE=MYISAM DEFAULT CHARSET=utf8��

/*�û���*/

CREATE TABLE USER (
  user_no INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '���',
  username VARCHAR(50) NOT NULL COMMENT '�û���' UNIQUE,
  PASSWORD VARCHAR(50) NOT NULL COMMENT '����',
  phone VARCHAR(20) NOT NULL  COMMENT '�ֻ���',
  user_power INT(10) NOT NULL COMMENT '�û�Ȩ��',
  salt VARCHAR(50) DEFAULT NULL COMMENT 'MD5���δ洢',
  var1 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�1',
  var2 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�2',
  var3 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�3',
  var4 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�4',
  var5 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�5'
) ENGINE=MYISAM DEFAULT CHARSET=utf8;

/*׮����*/

CREATE TABLE machine (
  machine_no VARCHAR(255) PRIMARY KEY NOT NULL  COMMENT '׮�����',
  design_length FLOAT(10) DEFAULT NULL COMMENT '���׮��,��ȷ����',
  real_length FLOAT(10) DEFAULT NULL COMMENT 'ʵ��׮��,��ȷ����',
  longitude FLOAT(10) NOT NULL  COMMENT '����',
  latitude FLOAT(10) NOT NULL COMMENT 'γ��',
  var1 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�1',
  var2 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�2',
  var3 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�3',
  var4 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�4',
  var5 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�5'
) ENGINE=MYISAM DEFAULT CHARSET=utf8;

/*�����*/

CREATE TABLE team (
  team_no INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '����id ',
  name VARCHAR(255) NOT NULL  COMMENT '��������',
  var1 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�1',
  var2 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�2',
  var3 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�3',
  var4 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�4',
  var5 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�5'
) ENGINE=MYISAM DEFAULT CHARSET=utf8;

/*׮��_�������¼��������Щ��׮��*/

CREATE TABLE machine_team (
  machine_team_no INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '���',
  team_no INT NOT NULL  COMMENT '����id',
  machine_no VARCHAR(255) NOT NULL  COMMENT '׮�����',
  var1 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�1',
  var2 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�2',
  var3 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�3',
  var4 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�4',
  var5 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�5'
) ENGINE=MYISAM DEFAULT CHARSET=utf8;

/*��Ŀ��*/

CREATE TABLE project(
  project_no INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '��Ŀid������',
  NAME VARCHAR(255) NOT NULL  COMMENT '��Ŀ����',
  plan_meters FLOAT(10) DEFAULT NULL COMMENT '�ƻ�����',
  plan_stakes FLOAT(10) DEFAULT NULL COMMENT '�ƻ�����',
  price VARCHAR(255) DEFAULT NULL COMMENT 'ÿ�׵ĵ���',
  begin_time DATE DEFAULT NULL COMMENT '��ʼʱ��',
  end_time  DATE DEFAULT NULL COMMENT '����ʱ��',
  var1 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�1',
  var2 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�2',
  var3 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�3',
  var4 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�4',
  var5 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�5'
) ENGINE=MYISAM DEFAULT CHARSET=utf8;

/*��Ŀ_����� ��¼��Ŀ������Щ���飬�Լ�ÿ�������ڱ���Ŀ�еļƻ�����*/

CREATE TABLE project_team(
  project_team_no INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '����',
  project_no INT  NOT NULL  COMMENT '��Ŀid',
  team_no INT  NOT NULL  COMMENT '����id',
  team_plan_meters FLOAT(10) DEFAULT NULL COMMENT '����ƻ�����',
  team_plan_stakes FLOAT(10) DEFAULT NULL COMMENT '����ƻ�����',
  var1 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�1',
  var2 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�2',
  var3 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�3',
  var4 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�4',
  var5 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�5'
) ENGINE=MYISAM DEFAULT CHARSET=utf8;

/* ��¼��Ŀ���Ǹ��û�����*/

CREATE TABLE project_user(
  project_user_no INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '����',
  user_no    INT NOT NULL  COMMENT '�û�id',
  project_no INT  NOT NULL  COMMENT '��Ŀid',
  begin_time DATE DEFAULT NULL COMMENT '��ʼʱ��',
  end_time  DATE DEFAULT NULL COMMENT '����ʱ��',
  var1 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�1',
  var2 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�2',
  var3 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�3',
  var4 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�4',
  var5 VARCHAR(255) DEFAULT NULL COMMENT '��չ�ֶ�5'
) ENGINE=MYISAM DEFAULT CHARSET=utf8;
/*

������Ŀ�е�ĳ�������������

��Ŀ_����_������ ��ͼ   �������ֶ�
	��Ŀid    int  
	���� id   int  
	��Ŀ��
	������      
	�ƻ�����
	�ƻ�����
	����ɸ���
	���������
	ˮ������
	ƽ������
	�����
	��ʼʱ��
	����ʱ��	

������Ŀ������������	 
	
��Ŀ_��������ͼ  �������ֶ�
	��Ŀid
	��Ŀ����
	�ƻ�����
	�ƻ�����
	ÿ�׵ĵ��� 
	����ɸ���
	���������
	����ɲ�ֵ
	�ܲ�ֵ
	�����
	��ʼʱ��
	����ʱ��		
*/

