#-*- coding:utf-8 -*-

from bs4 import BeautifulSoup
import requests
import re
import MySQLdb

db = MySQLdb.connect("localhost", "root", "heqingbao", "housing", charset='utf8')

url = "http://www.58.com/changecity.aspx"

def main():
	response = requests.get(url)
	html = BeautifulSoup(response.text)
	# html = BeautifulSoup(open("city.html"))
	cities = {}
	for a in html.find_all('a'):
		if a.has_attr('onclick') and not a.has_attr('class'):
			region = re.findall(r"co\(\'(.+?)\'\)", a['onclick'])[0]
			if not region.startswith('gl'):
				cities[region] = a.string

	# for abbr in cities.keys():
	# 	print cities[abbr], abbr
	cursor = db.cursor()
	try:
		for abbr in cities.keys():
			name = cities[abbr].encode("utf8")
			cursor.execute('insert into t_city(name, abbr) values(%s, %s)', (name, abbr))
		db.commit()
	except Exception as e:
		print e 
		db.rollback()
	finally:
		db.close()

if __name__ == '__main__':
	main()