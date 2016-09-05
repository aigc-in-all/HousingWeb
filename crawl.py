#-*- coding:utf-8 -*-
from bs4 import BeautifulSoup
from urlparse import urljoin
import requests
import csv

url = "http://sz.58.com/luohu/pinpaigongyu/"

csv_file = open("rent.csv", "wb")
csv_writer = csv.writer(csv_file, delimiter = ',')

def main():
	print "fetch:", url
	response = requests.get(url)
	html = BeautifulSoup(response.text)
	house_list = html.select(".list > li")

	if not house_list:
		retrun

	for house in house_list:
		house_title = house.select("h2")[0].string.encode("utf-8")
		house_url = urljoin(url, house.select("a")[0]["href"])
		house_info_list = house_title.split()

		if "公寓" in house_info_list[1] or "青年社区" in house_info_list[1]:
			house_location = house_info_list[0]
		else:
			house_location = house_info_list[1]

		house_money = house.select(".money")[0].select("b")[0].string.encode("utf-8")

		csv_writer.writerow([house_title, house_location, house_money, house_url])
		print house_title, house_url

if __name__ == '__main__':
	main()
