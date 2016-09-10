#-*- coding:utf-8 -*-

from bs4 import BeautifulSoup
from bs4 import NavigableString
import requests
import re
import MySQLdb

db = MySQLdb.connect("localhost", "root", "heqingbao", "housing", charset='utf8')

url = "http://www.58.com/changecity.aspx"

def main():
	# response = requests.get(url)
	# html = BeautifulSoup(response.text)
	html = BeautifulSoup(open("city.html"))
	cities = {}
	clist = html.select('clist')
	for dt in html.find_all('dt'):
		# print dt
		if not dt.has_attr('class'):
			cs = {}
			province = dt.string
			if province.encode('utf8') in ['其他', '热门城市']:
				continue
			print '>', province
			clist = dt.next_sibling if not isinstance(dt.next_sibling, NavigableString) else dt.next_sibling.next_sibling
			for a in clist:
				name = a.string
				abbr = re.findall(r"co\(\'(.+?)\'\)", a['onclick'])[0]
				# print name, abbr
				cs[abbr] = name
			cities[province] = cs

	for idx, val in enumerate(cities.keys(), start=1):
		# print idx, val
		insertProvince(val.encode('utf8'))

		cs = cities[val]
		for abbr, name in cities[val].items():
			insertCities(abbr.encode('utf8'), name.encode('utf8'), idx)

	db.close()

def insertProvince(province):
	cursor = db.cursor()
	try:
		cursor.execute('insert into province(name) values(%s)', [province])
		db.commit()
	except Exception, e:
		raise e
	else:
		cursor.close()

def insertCities(abbr, name, provinceId):
	cursor = db.cursor()
	try:
		sql = "INSERT INTO city(abbr, name, p_id) VALUES ('%s', '%s', '%d')" \
					% (abbr, name, provinceId)
		cursor.execute(sql)
		db.commit()
	except Exception, e:
		raise e
	else:
		cursor.close()

if __name__ == '__main__':
	main()