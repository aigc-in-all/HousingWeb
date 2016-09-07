#-*- coding:utf-8 -*-
from bs4 import BeautifulSoup
from urlparse import urljoin
import requests
import re
import sys
import MySQLdb

reload(sys)
sys.setdefaultencoding('utf8')

db = MySQLdb.connect("localhost", "root", "heqingbao", "housing", charset='utf8')

url = "http://sz.58.com/pinpaigongyu/pn/{page}"

def main():
	for page in range(1,21):
		print 'fetch: ', url.format(page=page)
		response = requests.get(url.format(page=page))
		html = BeautifulSoup(response.text)
		# html = BeautifulSoup(open('house.html'))
		house_list = html.select(".list > li")

		if not house_list:
			retrun

		cursor = db.cursor()
		try:
			for house in house_list:
				house_title = house.select("h2")[0].string.encode("utf-8").split(' ')
				house_url = urljoin(url, house.select("a")[0]["href"])
				house_img = house.select("img")[0]["lazy_src"]

				room = parseRoomTag(house.encode('utf-8'))
				house_type = room[0]
				house_area = room[1]
				house_floor = room[2]
				# print house_type, house_area, house_floor

				rent_price = house.find_all('div', class_='money')[0].select('b')[0].string
				rent_type = house_title[0][0:12]
				build_region = house_title[0][12:]
				rent_room = house_title[2]
				build_name = house_title[1]

				cursor.execute('insert into t_house(build_name, build_region, house_type, house_area, \
					house_floor, rent_type, rent_room, rent_price, img, url, c_abbr) \
					values (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)', \
					(build_name, build_region, house_type, house_area, house_floor, \
						rent_type, rent_room, rent_price, house_img, house_url, 'sz'))

				db.commit()
		except Exception, e:
			print e
			db.rollback()
		finally:
			cursor.close()
	db.close()
	

def parseRoomTag(tag):
	result = []
	rc = re.compile("<p class=\"room\">(.*?)</p>", re.DOTALL)
	s = rc.findall(tag)[0].split()

	t = [elem for elem in s if elem != '&nbsp;']
	for value in t:
		if value.startswith('<b>') == False :
			if value != '\xc2\xa0':
				result.append(value.encode('utf-8').strip())

	return result

if __name__ == '__main__':
	main()